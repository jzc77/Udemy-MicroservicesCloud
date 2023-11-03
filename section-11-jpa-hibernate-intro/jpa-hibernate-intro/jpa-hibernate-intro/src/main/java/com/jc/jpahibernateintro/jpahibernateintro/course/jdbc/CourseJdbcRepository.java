package com.jc.jpahibernateintro.jpahibernateintro.course.jdbc;

import com.jc.jpahibernateintro.jpahibernateintro.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
                values(?, ?, ?);
            """;

    private static String DELETE_QUERY =
            """
                delete from course
                where id = ?
            """;

    private static String SELECT_QUERY =
            """
                select * from course
                where id = ?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        // BeanPropertyRowMapper is used to map the queried results to a bean (e.g. Course.java)
        Course course = springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
        return course;
    }
}
