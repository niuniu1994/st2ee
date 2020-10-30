package com.efrei.st2ee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-24 12:36
 **/

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "student_group")
    private String studentGroup;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "company_name")
    private String companyName;

    private String charger;
    private String address;

    @Column(name = "note_tech")
    private Integer noteTech;

    @Column(name = "note_com")
    private Integer noteCom;

    private String description;

    private String comment;

    private boolean cdc;
    private boolean fv;
    private boolean fee;
    private boolean sw;
    private boolean rr;
    private boolean sout;
    private boolean plan;
    private boolean fait;

    @ManyToOne(targetEntity = Tutor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "t_id")
    private Tutor tutor;

}
