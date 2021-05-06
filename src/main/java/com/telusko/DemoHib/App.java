package com.telusko.DemoHib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		 int b=60;
		
		 
		 Query hibQuery = session1.createQuery("select sum(marks) as marks from Student where marks>:b");
		 hibQuery.setParameter("b", b);
		 Object student =  hibQuery.uniqueResult();
		 
		// for(Object s : student)
			 System.out.println(student);
		 
		 session1.getTransaction().commit();

		sf.close();
	}
}
