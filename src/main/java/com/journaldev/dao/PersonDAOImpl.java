package com.journaldev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	//private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);

////only for hibernate
//	private SessionFactory sessionFactory;
//	
//	@Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
	
	@PersistenceContext
	private EntityManager entityManager;

    
	@Override
	@Transactional
	public void save(Person p) {
		//Session session = this.sessionFactory.openSession();
		//Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		//session.persist(p);
		//tx.commit();
		//session.close();
		entityManager.persist(p);
	}
	
	public void delete (Person p){
		entityManager.remove(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
//		Session session = this.sessionFactory.openSession();
//		List<Person> personList = session.createQuery("from Person").list();
//		session.close();
//		return personList;
		Query query = entityManager.createQuery("SELECT m from Person as m");
		return query.getResultList();

	}
	
//	@Override
//	public List<Person> findAllPersons() {
//	    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//	    CriteriaQuery<Person> cq = builder.createQuery(Person.class);
//	    Root<Person> root = cq.from(Person.class);
//	    cq.select(root);
//	    return entityManager.createQuery(cq).getResultList();
//	  }

}