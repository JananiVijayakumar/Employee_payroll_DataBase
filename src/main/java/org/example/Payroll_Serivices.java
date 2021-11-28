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
            String sqlInsert = "INSERT INTO Employee_payroll_Services (Name, Salary, Start_Date, Gender) values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, "Jungkook");
            statement.setString(2, "30k");
            statement.setString(3, "12-12-1995");
            statement.setString(4, "M");
            statement.execute();
            statement.setString(1, "Jimin");
            statement.setString(2, "20k");
            statement.setString(3, "02-02-1993");
            statement.setString(4, "F");
            statement.execute();
            statement.setString(1, "Terisa");
            statement.setString(2, "25k");
            statement.setString(3, "02-11-1994");
            statement.setString(4, "F");
            statement.execute();
            statement.setString(1, "Terisa");
            statement.setString(2, "10k");
            statement.setString(3, "30-02-1995");
            statement.setString(4, "F");
            boolean rowsInserted = statement.execute();
            if (rowsInserted) {
                System.out.println("Row or data added successfully!!");
            }
            String sqlInsert1 = "INSERT INTO Employee_payroll_Services (Name, Salary, Start_Date, Gender) values ('Tae Hyung', '50k', '30-12-1996', 'M' )";
            int insertValue = readStatement.executeUpdate(sqlInsert1);
            if(insertValue > 0){
                System.out.println(" Employee Details Insert Sucessfully!!");
            }
            String sqlUpdate = "update Employee_payroll_Services set Base_pay=? where Name=?";
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
            preparedStatementUpdate.setInt(1, 30000);
            preparedStatementUpdate.setString(2, "Terisa");
            preparedStatementUpdate.executeUpdate();
            preparedStatementUpdate.setInt(1, 80000);
            preparedStatementUpdate.setString(2, "Tae Hyung");
            preparedStatementUpdate.executeUpdate();
            preparedStatementUpdate.setInt(1, 50000);
            preparedStatementUpdate.setString(2, "Jungkook");
            preparedStatementUpdate.executeUpdate();
            preparedStatementUpdate.setInt(1, 45000);
            preparedStatementUpdate.setString(2, "Jimin");
            preparedStatementUpdate.executeUpdate();
            int rowsEffected = preparedStatementUpdate.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Base Pay is updated Successfully!!");
            }

            String sqlRead = "SELECT * FROM Employee_payroll_Services";
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
