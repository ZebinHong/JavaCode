package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

public class CustomerList {
	private Customer[] customers;
	private int total = 0;

	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	public boolean addCustomer(Customer customer) {
		if (customers.length >= total) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}

	public boolean replaceCustomer(int index, Customer customer) {
		if (index < 0 || index > total - 1) {
			return false;
		}
		customers[index] = customer;
		return true;
	}

	public boolean deleteCustomer(int index){
		int i;
		if (index < 0 || index > total - 1) {
			return false;
		}
		for(i = index;i< total-1;++i){
			customers[i] = customers[i+1]; 
		}
		customers[--total] = null;
		return true;
	}
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for (int i = 0; i < total; ++i) {
			custs[i] = customers[i];
		}
		return custs;
	}

	public Customer getCustomer(int index) {
		if (index < 0 || index > total - 1) {
			return null;
		}
		return customers[index];
	}

	public int getTotal() {
		return total;
	}
}
