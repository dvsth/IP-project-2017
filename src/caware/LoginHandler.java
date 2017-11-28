/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 12p10
 */
public class LoginHandler {

    //create a reference to the database containing login table
    private static Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public LoginHandler() {

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cawaredb", "root", "root");
            System.out.println("LoginHandler - Database connection success.");
            statement = connection.createStatement();
            resultSet = statement.getResultSet();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }

    }

    public boolean authenticate(String id, String password) {

        String query = "select * from users where uid = '" + id + "' and password = '" + password + "'";
        try {
            resultSet = statement.executeQuery(query);
            return resultSet.first();
        } catch (Exception e) {
            System.out.println("LoginHandler - Failed to get result from users table!");
            e.printStackTrace();
        }

        return false;
    }

}
