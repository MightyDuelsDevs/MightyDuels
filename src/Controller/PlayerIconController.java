///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controller;
//
//import Database.Database;
//import Mighty_Cards.Domain.Icon;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Ramòn Janssen
// */
//public class PlayerIconController {
//
//    private ArrayList<Icon> icons;
//
//    public PlayerIconController() {
//        this.icons = new ArrayList<>();
//        createIcons();
//    }
//
//    public void createIcons() {
//        String statement = "SELECT * FROM ICON;";
//        int rowCount = 0;
//        
//        try {
//            if (Database.checkConnection()) {
//                ResultSet resultSet = Database.selectRecordFromTable(statement);
//
//                if (resultSet.last()) {
//                    rowCount = resultSet.getRow();
//                    resultSet.beforeFirst();
//                }
//                while (resultSet.next()) {
////                    ArrayList<String> rowCollumns = (ArrayList<String>) resultSet.getArra;
//                }
//
//            } else {
//                System.out.println("Database connection is lost.");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public ArrayList<Icon> getIcons(int rating) {
//        // rating
//        return this.icons;
//    }
//
//}
