package com.yourcodelab.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.dao.CustomerDAO;
import com.yourcodelab.model.Customer;

public class CustomerService {
	CustomerDAO dao = new CustomerDAO();
	public List<Customer> listAll(){
		List<Customer> list = new ArrayList<Customer>();
		try {
			list = dao.listar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertCustomer(Customer c){
		try {
			dao.cadastrar(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateCustomer(Customer c){
		try {
			dao.alterar(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteCustomer(Customer c){
		try {
			dao.excluir(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Customer> searchByName(String Nome){
		List<Customer> list = new ArrayList<Customer>();
		try {
			if(!Nome.isEmpty()){
				list = dao.procurar(Nome);
				
			}else{
				list = dao.listar();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
