package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Course;
import com.example.entity.Instructor;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml").buildSessionFactory();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Course course = session.get(Course.class, 1);
			System.out.println("Deleting course: " + course);
			
			session.delete(course);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
