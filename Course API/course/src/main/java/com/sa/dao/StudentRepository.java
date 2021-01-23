package com.sa.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Student> findAll() {
		Query query = entityManager.createQuery("from student");
		return query.getResultList();
	}
	
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
	
	@Transactional
	public Student save(Student student) {
		entityManager.persist(student);
		return student;
	}
	
	@Transactional
	public void delete(Student student) {
		entityManager.remove(student);
	}
}
