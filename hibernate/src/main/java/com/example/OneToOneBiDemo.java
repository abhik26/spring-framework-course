package com.example;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;

public class OneToOneBiDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
			session = sessionFactory.getCurrentSession();
			
			Instructor instructor = new Instructor("Megha", "Chabra", "megha.chabra@email.com");
//			
//			InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/megha_chabra", "Love to teach");
//			
//			instructor.setInstructorDetail(instructorDetail);
//			
//			session.beginTransaction();
//			
//			// This operation will also save instructor detail because of CascadeType.All
//			session.save(instructor);
//			
//			session.getTransaction().commit();
//			session.close();
//			System.out.println("Instructor saved with id: " + instructor.getId());
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from InstructorDetail");
			List<InstructorDetail> instructorDetails = query.getResultList();
			
			for (InstructorDetail id : instructorDetails) {
				System.out.println("fetching instructor for detail id: " + id.getId());
				instructor = id.getInstructor();
				System.out.println("Instructor fetched from InstructorDetail: " + instructor);
				instructor.setInstructorDetail(null);
				session.delete(id);
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}

}
