package com.telusko.DemoHib;

import java.util.Collection;
import java.util.List;
import java.util.Random;

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

		Alien a =null;
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		 session1.beginTransaction();
		 Random  r = new Random();
		 for(int i=0;i<=50;i++)
		 {
			 Student s = new Student();
			 s.setRollno(i);
			 s.setName("Name "+i);
			 s.setMarks(r.nextInt(100));
			 session1.save(s);
		 }
		 session1.getTransaction().commit();

		sf.close();
	}
}
