package com.school.school.service;

import com.school.school.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses(int pageNumber, int pageSize);
    Course saveCourse(Course course);
    Course getSingleCourse(Long id);
    void deleteCourse(Long id);
    Course updateCourse(Course course);

    //In Fact this method is kinda a filter by name
    List<Course> getCoursesByName(String name);

    List<Course> getCoursesByNameKeyword(String keyword);
}
