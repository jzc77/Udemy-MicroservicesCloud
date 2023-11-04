package com.jc.jpahibernateintro.jpahibernateintro.course.springdatajpa;

import com.jc.jpahibernateintro.jpahibernateintro.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {  // We want JpaRepository to manage the Course entity
    List<Course> findByAuthor(String author);  // custom method
    List<Course> findByName(String name);  // custom method
}
