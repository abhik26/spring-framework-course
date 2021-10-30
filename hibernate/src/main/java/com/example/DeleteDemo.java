package com.example;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Instructor;

public class DeleteDemo {

	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
			Session session = sessionFactory.getCurrentSession();
			
			session.beginTransaction();
			
			Query query = session.createQuery("from Instructor");
			List<Instructor> instructors = query.getResultList();
			
			for (Instructor instructor : instructors) {
				System.out.println("\n\nDeleting instructor with id: " + instructor.getId());
				if (instructor.getInstructorDetail() != null) {
					instructor.setInstructorDetail(null);
					System.out.println("not deleting associated instructor detail");
//					System.out.println("\nDeleting instructorDetail with id: " + instructor.getInstructorDetail().getId());
				}
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
