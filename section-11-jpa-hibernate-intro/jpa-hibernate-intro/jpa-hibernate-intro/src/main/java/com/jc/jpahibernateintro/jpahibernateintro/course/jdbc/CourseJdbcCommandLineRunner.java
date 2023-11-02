package com.jc.jpahibernateintro.jpahibernateintro.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Make this class run at application start up
@Component  // So Spring Framework can find CourseJdbcCommandLineRunner during component scan
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {  // Fire up the 'insert' query
        repository.insert();
    }
}
