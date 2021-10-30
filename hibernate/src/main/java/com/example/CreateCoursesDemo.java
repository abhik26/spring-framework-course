package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Course;
import com.example.entity.Instructor;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml").buildSessionFactory();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			Course course1 = new Course("Course1");
			Course course2 = new Course("course2");
			
			instructor.add(course1);
			instructor.add(course2);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
