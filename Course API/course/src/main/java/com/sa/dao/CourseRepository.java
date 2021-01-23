package com.sa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Course> findAll() {
		Query query = entityManager.createQuery("from course");
		return query.getResultList();
	}
	
	public Course findById(Integer id) {
		return entityManager.find(Course.class, id);
	}
	
	@Transactional
	public Course save(Course course) {
		entityManager.persist(course);
		return course;
	}
	
	@Transactional
	public void delete(Course course) {
		entityManager.remove(course);
	}
	
	@Transactional
	public void enrollCourse(Student student, Integer id) {
		Course course = entityManager.find(Course.class, id);
		course.addStudent(student);
		entityManager.persist(student);
	}
	
	@Transactional
	public void unEnrollCourse(Student student, Integer id) {
		Course course = entityManager.find(Course.class, id);
		course.removeStudent(student);
		entityManager.persist(student);
	}
}
