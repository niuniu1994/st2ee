/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efrei.st2ee.dao.impl.jdbc;

import com.efrei.st2ee.dao.TutorDao;
import com.efrei.st2ee.entity.Tutor;
import com.efrei.st2ee.utils.PropertiesUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import org.springframework.stereotype.Repository;

/**
 *
 * @author louis
 */
@Repository("jdbcTutorDao")
public class TutoJDBCDaoImpl implements TutorDao {

    private String dbUrl;
    private String dbUser;
    private String dbPwd;
    private String dbDriver;

    public TutoJDBCDaoImpl() {
        PropertiesUtils propertiesUtils = new PropertiesUtils();
        Properties prop = propertiesUtils.getDBPropertiesFile();
        this.dbUrl = prop.getProperty("database.url");
        this.dbUser = prop.getProperty("database.username");
        this.dbPwd = prop.getProperty("database.password");
        this.dbDriver = prop.getProperty("database.driverClass");
    }

    @Override
    public Tutor selectTutor(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
            String sql = "SELECT * FROM tutor where username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            Tutor tutor = new Tutor();
            while (resultSet.next()) {
                tutor.setTId(resultSet.getInt("t_id"));
                tutor.setTName(resultSet.getString("t_name"));
                tutor.setUsername(resultSet.getString("username"));
                tutor.setPassword(resultSet.getString("password"));
            }
            return tutor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
