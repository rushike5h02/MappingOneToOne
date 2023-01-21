package com.test;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Customer customer = new Customer();
		customer.setFirstName("rushi");
		customer.setMobileNumber("9284392116");

		Bill bill = new Bill();
		bill.setDate(new Date());
		bill.setTotal(2500);

		customer.setTransection(bill);

		session.save(customer);
		
		transaction.commit();
		
		System.out.println("Data Insertion Succesfull ");
		session.close();
		sessionFactory.close();

	}
}
