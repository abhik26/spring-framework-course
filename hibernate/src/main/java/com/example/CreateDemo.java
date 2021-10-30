package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
			Session session = sessionFactory.getCurrentSession();
			
			Instructor instructor = new Instructor("Megha", "Chabra", "megha.chabra@email.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/megha_chabra", "Love to teach");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			// This operation will also save instructor detail because of CascadeType.All
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Instructor saved with id: " + instructor.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
