package examples.hibernate.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import examples.hibernate.jpa.domain.entity.Person;
import examples.hibernate.jpa.domain.entity.Phone;

public class Test {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		Person p = new Person();
		p.setName("John-2");

		Phone phone1 = new Phone();
		phone1.setNumber("22334455-2");
		phone1.setOwner(p);
		
		Phone phone2 = new Phone();
		phone2.setNumber("44334466-2");
		phone2.setOwner(p);
		
		p.getPhones().add(phone1);
		p.getPhones().add(phone2);

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.persist(phone1);
			entityManager.persist(phone2);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
