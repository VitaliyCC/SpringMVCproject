package com.example.springmvcproject.dao;

import com.example.springmvcproject.model.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserDAO {
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:oracle:thin:@//195.182.202.156:15215/XEPDB1";
    private static final String USERNAME = "student_kb91_03";
    private static final String PASSWORD = "student";

    private static Connection connection;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void checkUser(User user) {
        try {
            String SQL = "SELECT  * from user where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,user.getName());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String SQL1 = "Update  user set MAX_TOTAL_POINTS = ? where name =? ";
                PreparedStatement preparedStatement1 = connection.prepareStatement(SQL1);
                preparedStatement1.setString(2,user.getName());
                preparedStatement1.setInt(1,user.getPoints());
                preparedStatement1.executeUpdate();
            } else {

                String SQL2 = "insert into user value (?,?,?)";
                PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);
                preparedStatement2.setInt(1, user.getId());
                preparedStatement2.setString(2, user.getName());
                preparedStatement2.setInt(3, user.getPoints());
                preparedStatement2.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public User showResult(){
        return null;
    }
}