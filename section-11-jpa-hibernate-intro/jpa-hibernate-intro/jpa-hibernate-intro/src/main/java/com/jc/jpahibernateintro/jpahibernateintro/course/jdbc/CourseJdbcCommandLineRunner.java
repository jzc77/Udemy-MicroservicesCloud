//package com.jc.jpahibernateintro.jpahibernateintro.course.jdbc;
//
//import com.jc.jpahibernateintro.jpahibernateintro.course.Course;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//// Make this class run at application start up
//@Component  // So Spring Framework can find CourseJdbcCommandLineRunner during component scan
//public class CourseJdbcCommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    private CourseJdbcRepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {  // Fire up the 'insert' query
//        repository.insert(new Course(1, "Learn AWS now!", "in28minutes"));
//        repository.insert(new Course(2, "Learn Azure now!", "in28minutes"));
//        repository.insert(new Course(3, "Learn DevOps now!", "in28minutes"));
//
//        repository.deleteById(2);
//
//        System.out.println(repository.findById(1));
//        System.out.println(repository.findById(3));
//    }
//}
