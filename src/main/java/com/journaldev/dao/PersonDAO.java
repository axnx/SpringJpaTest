package com.journaldev.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.journaldev.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}