package com;
import java.sql.*;

public class DbConnection {
    private String dbURL = "jdbc:mysql://localhost:3306/form";
    private String username = "root";
    private String password = "";
    private Connection connection;

    public DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, username, password);
            if (connection != null) {
                System.out.println("Success");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insertRecord(String fname, String lname,String email,String age,String gender, String address) {
        int noOfRowsInserted=0;
        try {

            String sqlQuery = "INSERT INTO student_info(fname,lname,email,age,gender,address) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, age);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, address);





            noOfRowsInserted = preparedStatement.executeUpdate();
            if (noOfRowsInserted > 0) {
                System.out.println(noOfRowsInserted + " rows inserted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  noOfRowsInserted;
    }

    public ResultSet getRecords() {
        try {
            String sqlQuery = "SELECT * FROM student_info";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlQuery);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int deleteRecord(String email) {
        try {
            String sqlQuery = "DELETE from student_info WHERE email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateRecord(String fname, String lname,String email,String age,String gender, String address) throws SQLException {
        try {
            String sqlQuery="UPDATE student_info SET fname=?, lname=?, age=?, gender=?, address=? WHERE email=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,fname);
            preparedStatement.setString(2,lname);
            preparedStatement.setString(3,age);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,address);
            preparedStatement.setString(6,email);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

