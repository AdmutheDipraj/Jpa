package com.neosoft.service.impl;

import com.neosoft.exception.CourseNotFoundException;
import com.neosoft.model.Course;
import com.neosoft.repository.CourseRepository;
import com.neosoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course upsert(Course course) {
        Course courses = courseRepository.save(course);   //upsert means insert/update the pk
        if(courses==null){
             throw new CourseNotFoundException("Course is not Inserted");
        }
        return courses;
    }

    @Override
    public Course getCourseById(Integer id) {
        Optional<Course> cid = courseRepository.findById(id);
        if(cid.isPresent()){
            return cid.get();
        }
        //return new CourseNotFoundException("The Given Course id is not present in given table");
        return null;
    }

//    @Override
//    public List<Course> getAllCourse() {
//        Iterable<Course> courseIterable = courseRepository.findAll();
//
//        // Convert Iterable<Course> to List<Course>
//        List<Course> courseList = new ArrayList<>();
//        courseIterable.forEach(courseList::add);
//
//        return courseList;
//    }

    @Override
    public String deleteById(Integer CId) {
        if (courseRepository.existsById(CId)){
            courseRepository.deleteById(CId);
//            courseRepository.deleteById(CId);
            return "Delete Success";
        }else{
            System.out.println("The Data is Not deleted");
        }

        return "Data Deleted Successfully";
    }

    @Override
    public List<Course> getAllCourses() {
        Iterable<Course> allcourse = courseRepository.findAll();
        if(allcourse==null){
            throw new CourseNotFoundException("Courses is not added properly");
        }
        return (List<Course>) allcourse;
    }

    @Override
    public List<Course> getListofCourse(String subject) {
        List<Course> coursesub = courseRepository.findBySubject(subject);
        if(coursesub==null){
            throw new CourseNotFoundException("Courses is Not present or Please add the course");
        }
        return coursesub;

    }

    @Override
    public List<Course> findByNameAndSubject(String name, String subject) {
        List<Course> courseNameAndSub = courseRepository.findByNameAndSubject(name, subject);
        if(courseNameAndSub==null ){
            throw new CourseNotFoundException("Courses subject and name is Not present or Please add the course");
        }

        return courseNameAndSub;
    }

}
