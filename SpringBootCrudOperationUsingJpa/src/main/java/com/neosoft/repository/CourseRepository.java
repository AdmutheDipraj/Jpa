package com.neosoft.repository;

import com.neosoft.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Serializable> {

    public List<Course> findBySubject(String subject);

    public List<Course> findByNameAndSubject(String name,String subject);
}
