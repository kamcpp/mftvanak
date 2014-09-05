package examples.hibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import examples.hibernate.jpa.domain.entity.Person;
import examples.hibernate.jpa.domain.entity.Phone;

public class SelectQueryTest {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		List<Person> people = (List<Person>) entityManager.createQuery(
				"from Person p").getResultList();

		for (Person p : people) {
			System.out.println(p.getName());
			/*
			 * for (Phone phone : p.getPhones()) { System.out.println("---> " +
			 * phone.getNumber()); }
			 */
			System.out.println("---------");
		}

		entityManagerFactory.close();
	}
}
