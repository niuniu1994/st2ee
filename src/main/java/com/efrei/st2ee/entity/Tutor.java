package com.efrei.st2ee.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-24 12:36
 **/

@Entity
@Table(name = "tutor")
@NoArgsConstructor
@Setter
@Getter
public class Tutor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Integer tId;

    @Column(name = "t_name",nullable = false)
    private String tName;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Student.class ,mappedBy = "tutor")
    private Set<Student> studentSet;

    @Override
    public String toString() {
        return "Tutor{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", password='" + password + '\''+
                '}';
    }
}
