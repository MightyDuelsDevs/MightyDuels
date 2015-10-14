/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ramòn Janssen & Martijn van Buul
 */
public class Database {

    private static final String url = "jdbc:oracle:thin:@192.168.2.14:1521/orcl";
    private static final String user = "MightyDuels";
    private static final String password = "MDPW";
    private static Connection connection = null;
    private static Database instance;

    /**
     * Open Database connection for the First time Searches driver Searches URL
     * tests connection Keeps connection open
     */
    private Database() {
        System.out.println("-------- Oracle JDBC Connection Initializing------");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to find driver.");
            return;
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Failed to find server: " + url + " (Denk aan secLab)");
            return;
        }

        if (connection != null) {
            System.out.println("Succes.");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    /**
     * Opens connection
     */
    public static void openConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Failed to find server: " + url);
                return;
            }
            if (connection != null) {
                System.out.println("Succes.");
            } else {
                System.out.println("Failed to make connection!");
            }
        } else {
            System.out.println("Connection to " + url + " is already opened");
        }
    }

    /**
     * Closes connection
     */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Failed to close connection!");
        }
    }

    /**
     * Check if connection is opened
     *
     * @return returns true if database connection is open
     * @throws java.sql.SQLException
     */
    public static boolean checkConnection() throws SQLException {
        if (connection == null) {
            openConnection();
        } else if (connection.isClosed()) {
            openConnection();
        }

        return !connection.isClosed();
    }

    /**
     * Inserts a Record into a table
     *
     * @param statement The executable SQL statement (DML)
     * @throws SQLException
     */
    public static void insertRecordIntoTable(String statement) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            openConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    //resultset execute
    /**
     *
     * @param statement The executable SQL statement (Select)
     * @return
     * @throws SQLException
     */
    public static ArrayList<ArrayList> selectRecordFromTable(String statement) throws SQLException {
        Statement selectStatement = null;
        ArrayList<ArrayList> dataSet = new ArrayList<>();
        
        try {
            selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(statement);
            
            ResultSetMetaData data = resultSet.getMetaData();
            while (resultSet.next()) {
                ArrayList<String> columnData = new ArrayList<>();
                
                for(int i = 1; i <= data.getColumnCount(); i++){
                    columnData.add(resultSet.getString(i));
                }
                
                dataSet.add(columnData);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (selectStatement != null) {
                selectStatement.close();
            }
        }
        return dataSet;
    }
}
