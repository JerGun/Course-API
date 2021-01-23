package com.sa.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Teacher> findAll() {
		Query query = entityManager.createQuery("from teacher");
		return query.getResultList();
	}
	
	public Teacher findById(Integer id) {
		return entityManager.find(Teacher.class, id);
	}
	
	@Transactional
	public Teacher save(Teacher teacher) {
		entityManager.persist(teacher);
		return teacher;
	}
	
	@Transactional
	public void delete(Teacher teacher) {
		entityManager.remove(teacher);
	}
}
