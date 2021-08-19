/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class GameStateTest {
    
    public GameStateTest() {
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
     * Test of getDeckCard method, of class GameState.
     */
    @Test
    public void testGetDeckCard() {
        System.out.println("getDeckCard");
        GameState instance = null;
        Card expResult = null;
        Card result = instance.getDeckCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrPlayer method, of class GameState.
     */
    @Test
    public void testGetCurrPlayer() {
        System.out.println("getCurrPlayer");
        GameState instance = null;
        int expResult = 0;
        int result = instance.getCurrPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeMove method, of class GameState.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        int player = 0;
        int choice = 0;
        GameState instance = null;
        boolean expResult = false;
        boolean result = instance.makeMove(player, choice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerOptions method, of class GameState.
     */
    @Test
    public void testGetPlayerOptions() {
        System.out.println("getPlayerOptions");
        int player = 0;
        GameState instance = null;
        String expResult = "";
        String result = instance.getPlayerOptions(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
