package com.atguigu.p2.ui;

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

public class CustomerView {
	CustomerList customerList = new CustomerList(10);

	public void enterMainMenu() {
		boolean isFlag = true;
		while (isFlag) {
			System.out.println("\n---------------客户信息管理软件---------------");
			System.out.println("                 1添加客户");
			System.out.println("                 2修改客户");
			System.out.println("                 3删除客户");
			System.out.println("                 4客户列表");
			System.out.println("                 5退  出\n");
			System.out.print("                 请选择(1-5)：");
			char menu = CMUtility.readMenuSelection();
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("确认是否退出(Y/N)");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					isFlag = false;
					System.out.println("退出成功");
				}
				break;
			}
		}
	}

	public void deleteCustomer() {
		int number;
		System.out.println("----------------------删除客户-----------------------");
		for (;;) {
			System.out.println("请选择待删除客户编号(-1退出):");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			} else {
				Customer cust = customerList.getCustomer(number - 1);
				if (cust == null) {
					System.out.println("找不到该用户");
				} else {
					break;
				}
			}
		}
		// 找到用户
		System.out.println("确认是否删除(Y/N)");
		char isDel = CMUtility.readConfirmSelection();
		if (isDel == 'Y') {
			boolean b = customerList.deleteCustomer(number - 1);
			if (b) {
				System.out.println("---------------删除成功-------------------");
			} else {
				System.out.println("---------------删除失败-------------------");
			}
		} else {
			return;
		}
	}

	public void modifyCustomer(){
		int number;
		Customer cust;
		System.out.println("--------------修改客户-----------------");
		for(;;){
			System.out.println("请选择待修改客户编号(-1退出):");
			number = CMUtility.readInt();
			if(number == -1){
				return;
			}else{
				cust = customerList.getCustomer(number-1);
				if(cust == null){
					System.out.println("无法找到该用户");
				}else{
					break;
				}
			}
		}
		System.out.println("姓名("+cust.getName()+"):");
		String name = CMUtility.readString(10,cust.getName());
		System.out.println("性别("+cust.getGender()+"):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.println("年龄("+cust.getAge()+"):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("电话("+cust.getPhone()+"):");
		String phone = CMUtility.readString(13,cust.getPhone());
		System.out.println("邮箱("+cust.getEmail()+"):");
		String email = CMUtility.readString(30,cust.getEmail());
		Customer  newCust= new Customer(name,gender,age,phone,email);
		boolean isMod = customerList.replaceCustomer(number-1,newCust);
		if(isMod){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}

	public void addNewCustomer(){
		System.out.println("------------------添加客户------------------");
		System.out.println("姓名：");
		String name = CMUtility.readString(10);
		System.out.println("性别：");
		char gender = CMUtility.readChar();
		System.out.println("年龄：");
		int age = CMUtility.readInt();
		System.out.println("电话：");
		String phone = CMUtility.readString(13);
		System.out.println("邮箱：");
		String email = CMUtility.readString(30);
		Customer customer = new Customer(name,gender,age,phone,email);
		boolean isSuc = customerList.addCustomer(customer);
		if(isSuc == false){
			System.out.println("客户已满,无法添加");
		}else{
			System.out.println("-------------添加完成--------------");
		}
	}

	public void listAllCustomers(){
		System.out.println("--------------------客户列表---------------------\n");
		int total = customerList.getTotal();
		if(total == 0){
			System.out.println("没有客户记录");
		}else{
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] customers = customerList.getAllCustomers();
			for(int i=0 ;i< total ;++i){
				Customer cust = customers[i];
				System.out.println((i+1)+"\t"+cust.getName()+
						"\t"+ cust.getGender()+"\t"+cust.getAge()+
						"\t"+cust.getPhone()+"\t"+cust.getEmail());;
			}
		}
		System.out.println("--------------------客户列表完成------------------\n");
	}
}
