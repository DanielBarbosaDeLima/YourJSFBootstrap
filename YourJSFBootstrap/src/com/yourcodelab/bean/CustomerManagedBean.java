package com.yourcodelab.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yourcodelab.model.Customer;
import com.yourcodelab.service.CustomerService;

@ManagedBean(name = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean implements Serializable{
	private static final long serialVersionUID = -9004785433894347006L;
	
	private Customer customer;
	private List<Customer> listCustomer;
	
	private CustomerService service;
	
	public CustomerManagedBean(){
		service = new CustomerService();
		customer = new Customer(0, "", "");
		listCustomer = service.listAll();
	}

	public String searchByNameAction(){
		this.listCustomer = service.searchByName(customer.getName());
		return "index";
	}
	
	public String insertCustomerAction(){
		service.insertCustomer(customer);
		this.listCustomer = service.listAll();
		return "index";
	}
	
	public String updateCustomerAction(){
		service.updateCustomer(customer);
		this.listCustomer = service.listAll();
		return "index";
	}
	public String deleteCustomerAction(){
		service.deleteCustomer(customer);
		this.listCustomer = service.listAll();
		return "index";
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}
	
}
