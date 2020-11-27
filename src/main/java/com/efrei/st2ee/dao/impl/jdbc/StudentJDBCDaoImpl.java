/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efrei.st2ee.dao.impl.jdbc;

import com.efrei.st2ee.dao.StudentDao;
import com.efrei.st2ee.dto.StudentInternshipExecution;
import com.efrei.st2ee.entity.Student;
import com.efrei.st2ee.entity.Tutor;
import com.efrei.st2ee.utils.PropertiesUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author louis
 */
@Repository("jdbcStudentDao")
public class StudentJDBCDaoImpl implements StudentDao {

    private String dbUrl;
    private String dbUser;
    private String dbPwd;
    private String dbDriver;

    public StudentJDBCDaoImpl() {
        Properties prop = (new PropertiesUtils()).getDBPropertiesFile();
        this.dbUrl = prop.getProperty("database.url");
        this.dbUser = prop.getProperty("database.username");
        this.dbPwd = prop.getProperty("database.password");
        this.dbDriver = prop.getProperty("database.driverClass");
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "INSERT INTO student(first_name, last_name, student_group, start_date, end_date, company_name, charger, address, note_tech, note_com, description, comment, cdc, fv,fee,sw,rr,sout,plan,fait,t_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try (Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getStudentGroup());
            preparedStatement.setDate(4, Date.valueOf(student.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(student.getEndDate()));
            preparedStatement.setString(6, student.getCompanyName());
            preparedStatement.setString(7, student.getCharger());
            preparedStatement.setString(8, student.getAddress());
            preparedStatement.setObject(9, student.getNoteTech());
            preparedStatement.setObject(10, student.getNoteCom());
            preparedStatement.setString(11, student.getDescription());
            preparedStatement.setString(12, student.getComment());
            preparedStatement.setBoolean(13, student.isCdc());
            preparedStatement.setBoolean(14, student.isFv());
            preparedStatement.setBoolean(15, student.isFee());
            preparedStatement.setBoolean(16, student.isSw());
            preparedStatement.setBoolean(17, student.isRr());
            preparedStatement.setBoolean(18, student.isSout());
            preparedStatement.setBoolean(19, student.isPlan());
            preparedStatement.setBoolean(20, student.isFait());
            preparedStatement.setInt(21, student.getTutor().getTId());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE student SET first_name = ?, last_name = ?, start_date = ?, end_date = ?, company_name = ?, charger = ?, address = ?, note_tech = ?, note_com = ?, description = ?, comment = ?, student_group = ? WHERE student_id = ?;";

        try (Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, Date.valueOf(student.getStartDate()));
            preparedStatement.setDate(4, Date.valueOf(student.getEndDate()));
            preparedStatement.setString(5, student.getCompanyName());
            preparedStatement.setString(6, student.getCharger());
            preparedStatement.setString(7, student.getAddress());
            if (student.getNoteTech() != null) {
                preparedStatement.setInt(8, student.getNoteTech());
            } else {
                preparedStatement.setNull(8, 0);
            }
            if (student.getNoteCom() != null) {
                preparedStatement.setInt(9, student.getNoteCom());
            } else {
                preparedStatement.setNull(9, 0);
            }
            preparedStatement.setString(10, student.getDescription());
            preparedStatement.setString(11, student.getComment());
            preparedStatement.setString(12, student.getStudentGroup());
            preparedStatement.setInt(13, student.getStudentId());
            preparedStatement.executeUpdate();
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateStudentInternship(StudentInternshipExecution internshipExecution) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE student SET ");
        for (int i = 0; i < internshipExecution.getCheckedList().size(); i++) {
            sql.append(internshipExecution.getNameList().get(i));
            sql.append("=");
            sql.append(internshipExecution.getCheckedList().get(i));
            if (i != internshipExecution.getCheckedList().size() - 1) {
                sql.append(",");
            }
        }
        sql.append(" WHERE student_id = ");
        sql.append(internshipExecution.getStudentId());
        try (Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Student> selectAllStudents(Integer tId) {
        String sql = "SELECT * FROM student  WHERE t_id = ?;";
        try (Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, tId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> listStudents = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setStudentGroup(resultSet.getString("student_group"));
                student.setCompanyName(resultSet.getString("company_name"));
                student.setCharger(resultSet.getString("charger"));
                student.setAddress(resultSet.getString("address"));
                student.setNoteTech(resultSet.getInt("note_tech"));
                student.setNoteCom(resultSet.getInt("note_com"));
                student.setDescription(resultSet.getString("description"));
                student.setComment(resultSet.getString("comment"));
                student.setStartDate(resultSet.getDate("start_date").toLocalDate());
                student.setEndDate(resultSet.getDate("end_date").toLocalDate());
                student.setCdc(resultSet.getInt("cdc") == 1);
                student.setFv(resultSet.getInt("fv") == 1);
                student.setFee(resultSet.getInt("fee") == 1);
                student.setSw(resultSet.getInt("sw") == 1);
                student.setRr(resultSet.getInt("rr") == 1);
                student.setSout(resultSet.getInt("sout") == 1);
                student.setPlan(resultSet.getInt("plan") == 1);
                student.setFait(resultSet.getInt("fait") == 1);
                listStudents.add(student);
            }
            return listStudents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student selectStudent(Integer sId, Integer tId) {
        String sql = "SELECT * FROM student  WHERE student_id = ? AND t_id = ?;";
        try (Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, sId);
            preparedStatement.setInt(2, tId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = new Student();
            while (resultSet.next()) {
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setStudentGroup(resultSet.getString("student_group"));
                student.setCompanyName(resultSet.getString("company_name"));
                student.setCharger(resultSet.getString("charger"));
                student.setAddress(resultSet.getString("address"));
                if (resultSet.getObject("note_tech") != null) {
                    student.setNoteTech(resultSet.getInt("note_tech"));
                } else {
                    student.setNoteTech(null);
                }
                if (resultSet.getObject("note_com") != null) {
                    student.setNoteCom(resultSet.getInt("note_com"));
                } else {
                    student.setNoteCom(null);
                }
                student.setDescription(resultSet.getString("description"));
                student.setComment(resultSet.getString("comment"));
                student.setStartDate(resultSet.getDate("start_date").toLocalDate());
                student.setEndDate(resultSet.getDate("end_date").toLocalDate());
                student.setCdc(resultSet.getInt("cdc") == 1);
                student.setFv(resultSet.getInt("fv") == 1);
                student.setFee(resultSet.getInt("fee") == 1);
                student.setSw(resultSet.getInt("sw") == 1);
                student.setRr(resultSet.getInt("rr") == 1);
                student.setSout(resultSet.getInt("sout") == 1);
                student.setPlan(resultSet.getInt("plan") == 1);
                student.setFait(resultSet.getInt("fait") == 1);
            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> selectStudentsByKeyWord(String keyWord, Integer tId) {
        String sql = "SELECT * FROM student  WHERE t_id = ? AND (lower(first_name) like lower(?) or lower(last_name) like lower(?) or student_group like upper(?));";

        try (Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, tId);
            preparedStatement.setString(2, "%" + keyWord + "%");
            preparedStatement.setString(3, "%" + keyWord + "%");
            preparedStatement.setString(4, "%" + keyWord + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> listStudents = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setStudentGroup(resultSet.getString("student_group"));
                student.setCompanyName(resultSet.getString("company_name"));
                student.setCharger(resultSet.getString("charger"));
                student.setAddress(resultSet.getString("address"));
                student.setNoteTech(resultSet.getInt("note_tech"));
                student.setNoteCom(resultSet.getInt("note_com"));
                student.setDescription(resultSet.getString("description"));
                student.setComment(resultSet.getString("comment"));
                student.setStartDate(resultSet.getDate("start_date").toLocalDate());
                student.setEndDate(resultSet.getDate("end_date").toLocalDate());
                student.setCdc(resultSet.getInt("cdc") == 1);
                student.setFv(resultSet.getInt("fv") == 1);
                student.setFee(resultSet.getInt("fee") == 1);
                student.setSw(resultSet.getInt("sw") == 1);
                student.setRr(resultSet.getInt("rr") == 1);
                student.setSout(resultSet.getInt("sout") == 1);
                student.setPlan(resultSet.getInt("plan") == 1);
                student.setFait(resultSet.getInt("fait") == 1);
                listStudents.add(student);
            }
            return listStudents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> selectStudentsByYear(Integer year, Integer tId) {
        String sql = "SELECT * FROM student WHERE t_id = ? AND YEAR(start_date) = ?;";
        try (Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, tId);
            preparedStatement.setInt(2, year);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> listStudents = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setStudentGroup(resultSet.getString("student_group"));
                student.setCompanyName(resultSet.getString("company_name"));
                student.setCharger(resultSet.getString("charger"));
                student.setAddress(resultSet.getString("address"));
                student.setNoteTech(resultSet.getInt("note_tech"));
                student.setNoteCom(resultSet.getInt("note_com"));
                student.setDescription(resultSet.getString("description"));
                student.setComment(resultSet.getString("comment"));
                student.setStartDate(resultSet.getDate("start_date").toLocalDate());
                student.setEndDate(resultSet.getDate("end_date").toLocalDate());
                student.setCdc(resultSet.getInt("cdc") == 1);
                student.setFv(resultSet.getInt("fv") == 1);
                student.setFee(resultSet.getInt("fee") == 1);
                student.setSw(resultSet.getInt("sw") == 1);
                student.setRr(resultSet.getInt("rr") == 1);
                student.setSout(resultSet.getInt("sout") == 1);
                student.setPlan(resultSet.getInt("plan") == 1);
                student.setFait(resultSet.getInt("fait") == 1);
                listStudents.add(student);
            }
            return listStudents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteStudent(Integer sId, Integer tId) {
        String sql = "DELETE FROM student WHERE student_id = ? AND t_id = ?;";
        try (Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, sId);
            preparedStatement.setInt(2, tId);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
