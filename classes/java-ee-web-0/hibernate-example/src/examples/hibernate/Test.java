package examples.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import examples.hibernate.domain.entity.Student;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Student student = new Student();
		student.setName("Abc");
		student.setFamily("Def");
		student.setAge(30);

		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.persist(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		sessionFactory.close();
	}
}
