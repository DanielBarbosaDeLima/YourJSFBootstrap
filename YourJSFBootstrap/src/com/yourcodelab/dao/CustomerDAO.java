package com.yourcodelab.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Customer;

public class CustomerDAO extends GenericDAO{
	private PreparedStatement ps;
	private String lista = "SELECT * FROM CUSTOMER";
	private String cadastrar = "INSERT INTO customer(nome,email) values(?,?); ";
	private String atualizar = "update customer set nome = ?, email = ? where id= ?; ";
	private String excluir = "delete from customer where id= ?";
	private String procurar = "select * from customer where nome = ?;";
	
	
	public List<Customer> listar() throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(lista);
		List<Customer> customers = new ArrayList<Customer>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			customers.add(new Customer(rs.getInt("id"),rs.getString("nome"),rs.getString("email")));
		}
		closeConnection();
		
		return customers;
	}
	public void cadastrar(Customer c) throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(cadastrar);
		
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		
		ps.execute();
		closeConnection();
	}
	public void alterar(Customer c) throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(atualizar);
		
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setInt(3, c.getId());
		
		ps.execute();
		closeConnection();
	}
	public void excluir(Customer c) throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(excluir);
		ps.setInt(1, c.getId());
		ps.execute();
		closeConnection();
	}
	public List<Customer> procurar(String Nome) throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(procurar);
		ps.setString(1, Nome);
		List<Customer> customers = new ArrayList<Customer>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			customers.add(new Customer(rs.getInt("id"),rs.getString("nome"),rs.getString("email")));
		}
		closeConnection();
		
		return customers;
	}
}
