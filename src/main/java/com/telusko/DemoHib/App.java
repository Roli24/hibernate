package com.telusko.DemoHib;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		// inserting data 

		/*
		 * Alien telusko = new Alien(); telusko.setAid(101); telusko.setAname("Roli");
		 * telusko.setColor("Green");
		 * 
		 * Laptop laptop = new Laptop(); laptop.setLid(101); laptop.setLname("Dell");
		 * 
		 * Student student = new Student(); student.setRollno(1);
		 * student.setName("Alien"); student.setMarks(50);
		 * laptop.getStudent().add(student); laptop.setAlien(telusko);
		 * telusko.getLaptop().add(laptop);
		 * 
		 * student.getLaptop().add(laptop);
		 */
		Alien a =null;
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		 session1.beginTransaction();
		 
		 Query query = session1.createQuery("from Alien where aid =1");
		 query.setCacheable(true);
		 a =(Alien) query.uniqueResult();
		//a= (Alien) session1.get(Alien.class, 1);
		System.out.println(a);
		
		//example of checking first level cache
		session1.getTransaction().commit();
		session1.close();
		Session session2= sf.openSession();
		session2.beginTransaction();
		 Query query1 = session2.createQuery("from Alien where aid =1");
		 query1.setCacheable(true);
			a = (Alien) query1.uniqueResult();
		
	//	a= (Alien) session2.get(Alien.class, 1);
		System.out.println(a);
		session2.getTransaction().commit();session2.close();
		//System.out.println(a);
		

		// session.save(telusko);

		// session.save(laptop); session.save(student);

		sf.close();
	}
}
