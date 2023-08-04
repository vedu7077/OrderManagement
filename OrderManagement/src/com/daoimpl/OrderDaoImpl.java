package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.connect.DBConnection;
import com.dao.OrderDao;
import com.entity.Order;

public class OrderDaoImpl implements OrderDao{
	
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	static Scanner sc= new Scanner(System.in);
	public OrderDaoImpl()
	{
		con= DBConnection.getConnect();
		try {
			st= con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public void addOrder(Order o) {
		try {
			pst=con.prepareStatement("insert into orderdetails values(?,?,?,?)");
			pst.setInt(1, o.getOrder_id());
			pst.setInt(2, o.getCid());
			pst.setInt(3, o.getItem_id());
			pst.setInt(4, o.getQty());
			int row=pst.executeUpdate();
			if(row>=1) {
				System.out.println("Order done..");
			}else {
				System.out.println("error...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int id) {
		try {
			pst=con.prepareStatement("delete from orderdetails where order_id=?");
			pst.setInt(1, id);
			int row=pst.executeUpdate();
			if(row>=1) {
				System.out.println("deleted order....");
			}else {
				System.out.println("error...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOrder(int id) {
		try {
			Order o=new Order();
			o=getOrderById(id);
			if(o!=null) {
				System.out.println("------------order details are----------");
				System.out.println(o);
				System.out.println("----------------------------------------");
				System.out.print("Enter the new Quantity: ");
				int qty=sc.nextInt();
				pst=con.prepareStatement("update orderdetails set qty=? where order_id=?");
				pst.setInt(1, qty);
				pst.setInt(2, id);
				int row=pst.executeUpdate();
				if(row>=1) {
					System.out.println("Order quantity updated...");
				}else {
					System.out.println("error..");
				}
			}else {
	    		 System.out.println("order id doesnot exist..........");

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Order getOrderById(int id) {
		try {
			pst=con.prepareStatement("select * from orderdetails where order_id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				Order o=new Order();
				o.setOrder_id(rs.getInt(1));
				o.setCid(rs.getInt(2));
				o.setItem_id(rs.getInt(3));
				o.setQty(rs.getInt(4));
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public void displayAllOrder() {
		
		try {
		
			rs=st.executeQuery("select * from orderdetails");
			System.out.println("--------------------------------");
			while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
			}
			System.out.println("--------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
