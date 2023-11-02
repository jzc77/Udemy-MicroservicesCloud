package com.jc.jpahibernateintro.jpahibernateintro.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Fire queries to database using Spring JDBC
@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =  // Called a text block, formatting retained
            """
                insert into course (id, name, author)
                values(1, 'Learn AWS', 'in28minutes');
            """;

    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
