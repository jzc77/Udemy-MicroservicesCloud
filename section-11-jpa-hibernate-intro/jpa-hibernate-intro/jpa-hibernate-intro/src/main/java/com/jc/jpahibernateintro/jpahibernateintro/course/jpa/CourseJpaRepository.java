package com.jc.jpahibernateintro.jpahibernateintro.course.jpa;

import com.jc.jpahibernateintro.jpahibernateintro.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext  // More specific than @Autowired
    private EntityManager entityManager;  // Manages entity (e.g. Course.java)

    public void insert(Course course) {
        entityManager.merge(course);  // All mappings have been done for you behind the scenes
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);  // We want to find a Course using the primary id
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

}