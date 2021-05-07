package com.telusko.DemoHib;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Alien a = em.find(Alien.class, 1);
		System.out.println(a);
		em.getTransaction().commit();
		
		
		/*
		 * System.out.println("Hello World!");
		 * 
		 * Alien a =null; Configuration con = new
		 * Configuration().configure().addAnnotatedClass(Student.class)
		 * .addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
		 * 
		 * ServiceRegistry reg = new
		 * ServiceRegistryBuilder().applySettings(con.getProperties()).
		 * buildServiceRegistry();
		 * 
		 * SessionFactory sf = con.buildSessionFactory(reg); Session session1 =
		 * sf.openSession(); session1.beginTransaction();
		 * 
		 * //detach and remove also load and get
		 * 
		 * Laptop l = new Laptop(); l.setLid(101); l.setLname("Sony");
		 * 
		 * session1.save(l);
		 * 
		 * l.setLname("Test"); session1.getTransaction().commit();
		 * 
		 * 
		 * sf.close();
		 */
	}
}
