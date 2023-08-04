package com.app;

import java.util.Scanner;

import com.dao.OrderDao;
import com.daoimpl.OrderDaoImpl;
import com.entity.Order;

public class OrderPanel {
	
	static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch;
		do
		{
			System.out.println("-------------Order Panel------------------------");
			System.out.println("1. Add Order");
			System.out.println("2. Delete Order");
			System.out.println("3. Update Item quantity");
			System.out.println("4. Display all Orders");
			System.out.println("5. Search Order by id");
			System.out.println("6. Exit");
			System.out.println("------------------------------");
			OrderDao od=new OrderDaoImpl();
			Order o=new Order();
			ch= sc.nextInt();
			switch(ch)
			{
			case 1:
				 System.out.print("Enter the order id:");
			        o.setOrder_id(sc.nextInt());
			     System.out.print("Enter the customer id:");
			        o.setCid(sc.nextInt());
				 System.out.print("Enter the item id:");
				o.setItem_id(sc.nextInt());
				 System.out.print("Enter the Quantity: ");
				 o.setQty(sc.nextInt());
				 od.addOrder(o);
				 break;
			case 2:
				System.out.print("Enter the oredr id to be deleted:");
				int id= sc.nextInt();
				od.deleteOrder(id);
				break;
			case 3:
				System.out.print("Enter the order id to be updated:");
				id=sc.nextInt();
				od.updateOrder(id);
				break;
			case 4:
				od.displayAllOrder();
				break;
			case 5:
				System.out.print("Enter the order id to be displayed:");
				id= sc.nextInt();
				o=od.getOrderById(id);
				 System.out.println("-----------------------------------------------------");
				    if(o!=null)
				    {
				    	System.out.println(o);
				    }
				    else
				    {
				    	System.out.println("No order with this id exists.........");
				    }
				    System.out.println("----------------------------------------------------");
				    break;
				
			case 6:
				MyApp.main(null);
				break;
			default: 
				System.out.println("Wrong choice...........");         

			
			}
			
		}while(ch!=6);
		
		
		
	}
	

}
