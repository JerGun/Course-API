package com.sa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Api {

//	Repository
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
//	Student Mapping
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") Integer id) {
		return studentRepository.findById(id);
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable("id") Integer id) {
		Student student = studentRepository.findById(id);
		studentRepository.delete(student);
	}
	
	@PutMapping("/student")
	public void editStudent(@RequestBody Student student) {
		Student editStudent = studentRepository.findById(student.getStudentId());
		editStudent.setFirstName(student.getFirstName());
		editStudent.setLastName(student.getLastName());
		editStudent.setStatus(student.getStatus());
		studentRepository.save(editStudent);
	}
	
//	Course Mapping
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	@GetMapping("/course/{id}")
	public Course getCourse(@PathVariable("id") Integer id) {
		return courseRepository.findById(id);
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	@DeleteMapping("/course/{id}")
	public void deleteCourse(@PathVariable("id") Integer id) {
		Course course = courseRepository.findById(id);
		courseRepository.delete(course);
	}
	
	@PutMapping("/course")
	public void editCourse(@RequestBody Course course) {
		Course editCourse = courseRepository.findById(course.getCoureseId());
		editCourse.setCourseName(course.getCourseName());
		editCourse.setCourseCapacity(course.getCourseCapacity());
		editCourse.setTeacher(course.getTeacher());
		courseRepository.save(editCourse);
	}
	
//	Teacher Mapping
	@GetMapping("/teachers")
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}
	
	@GetMapping("/teacher/{id}")
	public Teacher getTeacher(@PathVariable("id") Integer id) {
		return teacherRepository.findById(id);
	}
	
	@PostMapping("/teacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	@DeleteMapping("/teacher/{id}")
	public void deleteTeacher(@PathVariable("id") Integer id) {
		Teacher teacher = teacherRepository.findById(id);
		teacherRepository.delete(teacher);
	}
	
	@PutMapping("/teacher")
	public void editTeacher(@RequestBody Teacher teacher) {
		Teacher editTeacher = teacherRepository.findById(teacher.getTeacherId());
		editTeacher.setFirstName(teacher.getFirstName());
		editTeacher.setLastName(teacher.getLastName());
		editTeacher.setStatus(teacher.getStatus());
		teacherRepository.save(editTeacher);
	}
		
//	Enroll & UnEnroll Mapping
	@PostMapping("/enroll/{studentId}/{courseId}")
	public void enrollCourse(@PathVariable("studentId") Integer studentId, @PathVariable("courseId") Integer courseId) {
		Student student = studentRepository.findById(studentId);
		courseRepository.enrollCourse(student, courseId);
	}
	
	@DeleteMapping("unenroll/{studentId}/{courseId}")
	public void unenrollCourse(@PathVariable("studentId") Integer studentId, @PathVariable("courseId") Integer courseId) {
		Student student = studentRepository.findById(studentId);
		courseRepository.unEnrollCourse(student, courseId);
	}
}
