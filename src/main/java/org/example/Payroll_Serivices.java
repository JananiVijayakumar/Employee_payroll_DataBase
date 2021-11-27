package org.example;

import java.sql.*;

public class Payroll_Serivices {
    public static void main(String[] args) {
        String schoolURL = "jdbc:mysql://localhost:3306/school";
        String userName = "root";
        String passWord = "Vkumar@47";
        try {
            Connection connection = DriverManager.getConnection(schoolURL, userName, passWord);
            if (connection != null) {
                System.out.println("Connected successfully!!");
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
