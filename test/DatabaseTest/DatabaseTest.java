/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseTest;

import Database.Database;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramòn Janssen
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of openConnection method, of class Database.
     */
    @Test
    public void testOpenConnection() {
        System.out.println("openConnection");
        Database.openConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class Database.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        Database.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkConnection method, of class Database.
     */
    @Test
    public void testCheckConnection() throws Exception {
        System.out.println("checkConnection");
        boolean expResult = false;
        boolean result = Database.checkConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertRecordIntoTable method, of class Database.
     */
//    @Test
//    public void testInsertRecordIntoTable() throws Exception {
//        System.out.println("insertRecordIntoTable");
//        String statement = "";
//        Database.DMLRecordIntoTable(statement);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of selectRecordFromTable method, of class Database.
     */
    @Test
    public void testSelectRecordFromTable() throws Exception {
        System.out.println("selectRecordFromTable");
        String statement = "";
        ArrayList<ArrayList> expResult = null;
        ArrayList<ArrayList> result = Database.selectRecordFromTable(statement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
