package com.efrei.st2ee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.Data;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-24 12:36
 **/

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "student_group", nullable = false)
    private String studentGroup;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "charger", nullable = false)
    private String charger;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "note_tech")
    private Integer noteTech;

    @Column(name = "note_com")
    private Integer noteCom;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
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
