package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.entity.Instructor;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml").buildSessionFactory();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
//			Instructor instructor = session.get(Instructor.class, 1);
//			System.out.println(instructor);
//			System.out.println("fetching instructor courses...");
			
			Query<Instructor> query = session.createQuery("from Instructor i join fetch i.courses where i.id = :instructorId");
			query.setParameter("instructorId", 1);
			Instructor instructor = query.getSingleResult();
			
			session.getTransaction().commit();
			
			System.out.println("Instructor courses: " + instructor.getCourses());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
