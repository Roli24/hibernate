package com.telusko.DemoHib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Laptop {
	
	@Id
	private int lid;
	private String lname;
	
	@ManyToOne(targetEntity = Alien.class)
	private Alien Alien;
	
	@ManyToMany
	private List<Student> student= new ArrayList<>();

	public Alien getAlien() {
		return Alien;
	}
	public void setAlien(Alien alien) {
		Alien = alien;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	public List<Student> getStudent() {
		return student;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	
	

}
