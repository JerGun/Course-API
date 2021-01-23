package com.sa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer coureseId;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_capacity")
	private Integer courseCapacity;

	public Integer getCoureseId() {
		return coureseId;
	}

	public void setCoureseId(Integer coureseId) {
		this.coureseId = coureseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseCapacity() {
		return courseCapacity;
	}

	public void setCourseCapacity(Integer courseCapacity) {
		this.courseCapacity = courseCapacity;
	}
	
	@ManyToMany(mappedBy = "enrollCourse")
	private List<Student> enroll = new ArrayList<Student>();
	
	public void addStudent(Student student) {
		this.enroll.add(student);
		student.getEnrollCourse().add(this);
	}
	
	public void removeStudent(Student student) {
		this.enroll.remove(student);
		student.getEnrollCourse().remove(this);
	}
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@JsonBackReference
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
