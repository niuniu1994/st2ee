package com.efrei.st2ee.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Integer tId;

    @Column(name = "t_name")
    private String tName;

    private String username;

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
