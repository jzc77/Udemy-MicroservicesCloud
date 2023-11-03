package com.jc.jpahibernateintro.jpahibernateintro.course;

import com.jc.jpahibernateintro.jpahibernateintro.course.jdbc.CourseJdbcRepository;
import com.jc.jpahibernateintro.jpahibernateintro.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Make this class run at application start up
@Component  // So Spring Framework can find CourseJdbcCommandLineRunner during component scan
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {  // Fire up the 'insert' query
        repository.insert(new Course(1, "Learn JPA now 1!", "in28minutes"));
        repository.insert(new Course(2, "Learn JPA now 2!", "in28minutes"));
        repository.insert(new Course(3, "Learn JPA now 3!", "in28minutes"));

        repository.deleteById(2);

        System.out.println(repository.findById(1));
        System.out.println(repository.findById(3));
    }
}
