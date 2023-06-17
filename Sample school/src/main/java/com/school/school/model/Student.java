package com.school.school.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity

@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" )
    private long id;

    @Column(name = "name")
// I prefer use all three annotations (@NotNull @NotEmpty @NotBlank) to make errors clearer
    @NotNull @NotEmpty @NotBlank
    private String name;

    @Column(name = "location")
// I prefer use all three annotations (@NotNull @NotEmpty @NotBlank) to make errors clearer
    @NotNull @NotEmpty @NotBlank
    private String location;

    @Column(name = "JYear")
    private int joinYear;

    @Column(name = "age")
    private Long age=0L;

    @Column(name = "email")
    @Email(message = "Pls enter a valid email address")
    private String email;

    @CreationTimestamp
    @Column(name = "created_at" , nullable = false , updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
