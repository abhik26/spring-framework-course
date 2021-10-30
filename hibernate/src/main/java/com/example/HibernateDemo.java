package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Student;

public class HibernateDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
//			Student student = new Student("Isha", "Anand", null);
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, 5l);
			
			session.delete(student);
			System.out.println("deleted student id: " + student.getId());
			session.save(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
