package com.journaldev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import com.journaldev.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);

////only for hibernate
//	private SessionFactory sessionFactory;
//	
//	@Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
	
	@PersistenceContext
	EntityManager em;
    
	@Override
	public void save(Person p) {
		//Session session = this.sessionFactory.openSession();
		//Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		//session.persist(p);
		//tx.commit();
		//session.close();
		em.persist(p);
	}
	
	public void delete (Person p){
		em.remove(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
//		Session session = this.sessionFactory.openSession();
//		List<Person> personList = session.createQuery("from Person").list();
//		session.close();
//		return personList;
		Query query = em.createQuery("SELECT m from person as m");
		return query.getResultList();

	}
	
	@Override
	public List<Person> findAllPersons() {
	    CriteriaBuilder builder = em.getCriteriaBuilder();
	    CriteriaQuery<Person> cq = builder.createQuery(Person.class);
	    Root<Person> root = cq.from(Person.class);
	    cq.select(root);
	    return em.createQuery(cq).getResultList();
	  }

}