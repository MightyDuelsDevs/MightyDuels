/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Martijn
 */
public class Database {
    
    public static void main(String[] argv) {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to find driver.");
            return;
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.14:1521/orcl", "MightyDuels", "MDPW");
        } catch (SQLException e) {
            System.out.println("Failed to find server.");
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
