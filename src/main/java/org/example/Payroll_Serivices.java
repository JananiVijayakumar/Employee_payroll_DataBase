package org.example;

import java.sql.*;

public class Payroll_Serivices {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/Employee_payroll";
        String userName = "root";
        String passWord = "Vkumar@47";
        try {
            Connection connection = DriverManager.getConnection(dbURL, userName, passWord);
            if (connection != null) {
                System.out.println("Connected successfully!!");
            }
            Statement readStatement = connection.createStatement();
            String sqlSelect = "select * from Employee_payroll_services where name = ?";
            PreparedStatement preparedStatementSelect = connection.prepareStatement(sqlSelect);
            preparedStatementSelect.setString(1, "Terisa");
            preparedStatementSelect.execute();
            boolean rowsSelected = preparedStatementSelect.execute();
            if (rowsSelected) {
                System.out.println("Retrieved Successfully!!");
            }
            String sqlRead = "select * from Employee_payroll_Services";
            ResultSet resultSet = readStatement.executeQuery(sqlRead);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String Name = resultSet.getString("Name");
                String Salary = resultSet.getString("Salary");
                String Start_Date = resultSet.getString("Start_Date");
                String Gender = resultSet.getString("Gender");
                int Base_pay = resultSet.getInt("Base_pay");
                System.out.println(id + " | " + Name + " | "+ Salary + " | "+ Start_Date + " | "+Gender + " | "+Base_pay);
            }
            connection.close();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
