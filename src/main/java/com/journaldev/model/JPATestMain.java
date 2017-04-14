package com.journaldev.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class JPATestMain {
	
     private static final String PERSISTENCE_UNIT_NAME = "MyPU";
     private static EntityManagerFactory emf;

     public static void main(String[] args) {
          emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
          //EntityManagerFactory emf = Utility.setUpEntityManagerFactory();
          
          EntityManager em = emf.createEntityManager();
          // Read the existing entries and write to console
          Query q = em.createQuery("SELECT u FROM Person u");
          List<Person> personList = q.getResultList();
          for (Person person : personList) {
               System.out.println(person.getName());
          }
          //System.out.println("Size: " + person.size());

          // Create new user
          em.getTransaction().begin();
          Person person = new Person();
          person.setName("Tom Johnson");
          person.setCountry("Germany");
          em.persist(person);
          em.getTransaction().commit();

          em.close();
          emf.close();
     }
}