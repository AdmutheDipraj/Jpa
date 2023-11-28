package com.neosoft.controller;

import com.neosoft.dto.ResponseDTO;
import com.neosoft.dto.ResponseEntityUtils;
import com.neosoft.model.Course;
import com.neosoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseRestController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<ResponseDTO> CreateCourse(@RequestBody Course course) {
           // Response response = new Response(HttpStatus.CREATED.value(), "Data Successfully Inserted", "", List.of());
        return ResponseEntityUtils.get(courseService.upsert(course), "Data Successfully Inserted");
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllCourses() {

        return ResponseEntityUtils.get(courseService.getAllCourses(),"All courses fetched successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getCourseById(@PathVariable("id") Integer id){
       // Course cid = courseService.getCourseById(id);
        return ResponseEntityUtils.get(courseService.getCourseById(id),"Course Fetch Successfully");
    }

    @PutMapping()
    public ResponseEntity<ResponseDTO> updateCourse(@RequestBody Course course){

        return ResponseEntityUtils.get(courseService.upsert(course), "Data Updated Successfully.");
    }
    @DeleteMapping("/id")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable("id") Integer Id){
       // courseService.deleteById(Id);
        return ResponseEntityUtils.get(courseService.deleteById(Id),"Data Deleted Successfully");
    }
    @GetMapping("/subject/{subject}")
    public ResponseEntity<ResponseDTO> getListofCourse(@PathVariable("subject") String subject){

        return ResponseEntityUtils.get(courseService.getListofCourse(subject),"All courses fetched on the basis of subject successfully");
    }
    @GetMapping("/findByNameAndSubject")
    public ResponseEntity<ResponseDTO> findByNameAndSubject(String name, String subject){

        return ResponseEntityUtils.get(courseService.findByNameAndSubject(name, subject),"All courses fetched on the basis Name and subject successfully");
    }
}
