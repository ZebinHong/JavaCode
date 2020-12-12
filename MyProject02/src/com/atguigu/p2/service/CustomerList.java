package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

/**
 * CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 * 并提供相应的增删改查方法，供CustomerView调用
 * 
 * @author 86150
 *
 */
public class CustomerList {
	private Customer[] customers; // 用来保存客户对象的数组
	private int total = 0; // 记录已保存客户对象的数量

	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	public boolean addCustomer(Customer customer) {
		if (total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}

	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= total) {
			return false;
		}
		customers[index] = cust;
		return true;
	}

	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		}
		for (int i = index; i < total - 1; ++i) { // 将要删除的元素后面的往前放
			customers[i] = customers[i + 1];
		}
		// 最后一个元素设置为空
		customers[total - 1] = null;
		total--;
		return true;
	}

	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for (int i = 0; i < total; ++i) {
			custs[i] = customers[i]; // 此处只是将customers数组的对象的地址赋值给了custs
		}
		return custs;
	}

	public Customer getCustomer(int index) {
		if (index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}

	public int getTotal() {
		return total;
	}
}
