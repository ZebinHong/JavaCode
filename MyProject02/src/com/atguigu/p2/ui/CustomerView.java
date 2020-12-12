package com.atguigu.p2.ui;

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 *
 * @author 86150
 *
 */
public class CustomerView {

	private CustomerList customerList = new CustomerList(10);
	private boolean isFlag = true;

	public void enterMainMenu() {
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
				System.out.print("确认是否退出(Y/N):");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					isFlag = false;
					System.out.println("退出成功.");
				}
				break;
			}
		}

	}

	/**
	 * @Title: deleteCustomer @Description: TODO(这里用一句话描述这个方法的作用) @param
	 *         参数 @return void 返回类型 @throws
	 */
	private void deleteCustomer() {
		// TODO Auto-generated method stub
		System.out.println("----------------------删除客户-----------------------");
		int number;
		for (;;) {
			System.out.println("请选择待删除客户编号(-1退出):");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			}
			Customer customer = customerList.getCustomer(number - 1);
			if (customer == null) {
				System.out.println("无法找到指定客户");
			} else {
				break;
			}
		}
		// 找到指定客户
		System.out.println("确认是否删除(Y/N)");
		char isDel = CMUtility.readConfirmSelection();
		if (isDel == 'Y') {
			boolean delSucc = customerList.deleteCustomer(number - 1);
			if (delSucc) {
				System.out.println("---------------删除成功-------------------");
			} else {
				System.out.println("---------------删除失败-------------------");
			}
		} else {
			return;
		}
	}

	/**
	 * @Title: modifyCustomer @Description: TODO(这里用一句话描述这个方法的作用) @param
	 *         参数 @return void 返回类型 @throws
	 */
	private void modifyCustomer() {
		// TODO Auto-generated method stub
		System.out.println("--------------修改客户-----------------");
		Customer cust;
		int number;
		for (;;) {
			System.out.println("请选择待修改客户编号(-1退出):");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			}
			cust = customerList.getCustomer(number - 1);
			if (cust == null) {
				System.out.println("无法找到客户!");
			} else {// 找到相应的编号的客户
				break;
			}
		}
		// 修改客户信息
		System.out.print("姓名(" + cust.getName() + "):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("性别(" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("年龄(" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("电话(" + cust.getPhone() + "):");
		String phone = CMUtility.readString(13, cust.getPhone());
		System.out.print("邮箱(" + cust.getEmail() + "):");
		String email = CMUtility.readString(30, cust.getEmail());
		Customer newCust = new Customer(name, gender, age, phone, email);
		customerList.replaceCustomer(number - 1, newCust);
	}

	/**
	 * @Title: addNewCustomer @Description: TODO(这里用一句话描述这个方法的作用) @param
	 *         参数 @return void 返回类型 @throws
	 */
	private void addNewCustomer() {
		// TODO Auto-generated method stub
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
		// 将上述数据封装到对象中
		Customer customer = new Customer(name, gender, age, phone, email);
		boolean isSuc = customerList.addCustomer(customer);
		if (isSuc == false) {
			System.out.println("客户已满,无法添加");
		} else {
			System.out.println("-------------添加完成--------------");
		}
	}

	/**
	 * @Title: listAllCustomers @Description: TODO(列出客户列表) @param 参数 @return
	 *         void 返回类型 @throws
	 */
	private void listAllCustomers() {
		// TODO Auto-generated method stub
		System.out.println("--------------------客户列表---------------------\n");
		int total = customerList.getTotal();
		if (total == 0) {
			System.out.println("没有客户记录");
		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; ++i) {
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
						+ "\t" + cust.getPhone() + "\t" + cust.getEmail()); // 这里注意\t不能用单引号'，否则是加法操作
			}
		}
		System.out.println("--------------------客户列表完成------------------\n");
	}

	public static void main(String args[]) {
		CustomerView customerView = new CustomerView();
		customerView.enterMainMenu();
	}
}
