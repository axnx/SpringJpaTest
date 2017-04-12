package com.journaldev.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.conf.HibernateConfig;
import com.journaldev.conf.JpaConfig;
import com.journaldev.dao.PersonDAO;
import com.journaldev.dao.PersonDAOImpl;
import com.journaldev.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		//ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class, PersonDAOImpl.class);
		//ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class, PersonDAOImpl.class);
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		//PersonDAO personDAO = new PersonDAOImpl();
		Person person = new Person();
		person.setName("Pankaj"); person.setCountry("India");
		
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		//close resources
		//context.	
	}
}