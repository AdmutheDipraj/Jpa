package com.neosoft.service;

import com.neosoft.model.Course;

import java.util.List;

public interface CourseService {

    public Course upsert(Course course);

    public Course getCourseById(Integer id);

   // public List<Course> getAllCourse();

    public String deleteById(Integer Id);

    List<Course> getAllCourses();

    public List<Course> getListofCourse(String subject);

    public List<Course> findByNameAndSubject(String name,String subject);
}
