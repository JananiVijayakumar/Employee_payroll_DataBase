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
            String sqlCreate = "create table Employee_payroll_Services (id int(50) auto_increment, Name varchar(50),Salary varchar(50),Start_Date varchar(10), Gender varchar(10), Base_pay float(50), primary key(id))";
            int createValue=readStatement.executeUpdate(sqlCreate);
            if(createValue > 0){
                System.out.println("Employee payroll services database Created Sucessfully!!");
            }
            String sqlInsert = "INSERT INTO Employee_payroll_Services (Name, Salary, Start_Date, Gender) values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, "Jungkook");
            statement.setString(2, "Jeon");
            statement.setString(3, "12-12-1995");
            statement.setString(4, "M");
            statement.execute();
            statement.setString(1, "Jimin");
            statement.setString(2, "kim");
            statement.setString(3, "02-02-1993");
            statement.setString(4, "F");
            statement.execute();
            statement.setString(1, "Terisa");
            statement.setString(2, "sung");
            statement.setString(3, "02-11-1994");
            statement.setString(4, "F");
            statement.execute();
            statement.setString(1, "Terisa");
            statement.setString(2, "kim");
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
            String sqlRead = "SELECT * FROM Employee_payroll_Services";
            ResultSet resultSet = readStatement.executeQuery(sqlRead);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String Name = resultSet.getString("Name");
                String Salary = resultSet.getString("Salary");
                String Start_Date = resultSet.getString("Start_Date");
                String Gender = resultSet.getString("Gender");
                String Base_pay = resultSet.getString("Base_pay");
                System.out.println(id + " | " + Name + " | "+ Salary + " | "+ Start_Date + " | "+Gender + " | "+Base_pay);
            }
            connection.close();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
