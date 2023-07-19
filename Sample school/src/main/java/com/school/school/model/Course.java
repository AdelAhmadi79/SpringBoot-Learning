package com.school.school.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity

@Table(name = "tbl_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private long id;

    @Column(name = "course_title")
// I prefer use all three annotations (@NotNull @NotEmpty @NotBlank) to make errors clearer
    @NotNull @NotEmpty @NotBlank
    private String title;

    @Column
    private String department;

    @Column
    private int capacity;

    @Column
    private int duration;

    @Column
    private String instructor;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @CreationTimestamp
    @Column(name = "created_at" , nullable = false , updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
//Todo: check again
    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes;

}