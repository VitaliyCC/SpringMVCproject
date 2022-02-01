package com.example.springmvcproject.dao;

import com.example.springmvcproject.model.Questions;
import com.example.springmvcproject.model.User;

import java.sql.*;
import java.util.ArrayList;

public class QuestionsDAO {
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

    public ArrayList<Questions> getQuestions() {
        try {
            ArrayList<Questions> questionsArrayList = new ArrayList<>();
            String SQL = "Select * from questions";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Questions questions = new Questions();
                questions.setId(resultSet.getInt("ID"));
                questions.setQestion(resultSet.getString("QUESTION"));
                questions.setAnsver(resultSet.getString("ANSWER"));
                questions.setPoint(resultSet.getInt("POINTS"));

                if (questions.getId() % 2 == 0)
                    questionsArrayList.add(questions);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return questionsArrayList;
    }
}
