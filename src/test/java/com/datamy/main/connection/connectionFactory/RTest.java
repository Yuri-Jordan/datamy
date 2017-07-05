/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.connection.connectionFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.rosuda.REngine.Rserve.RConnection;

/**
 *
 * @author yuri
 */
public class RTest {
    
    public RTest() {
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
     * Test of getRconexao method, of class R.
     */
    @org.junit.Test
    public void testGetRconexao() {
       RConnection con = new R().getRconexao();
       assertNotNull(con);
    }
    
    @org.junit.Test
    public void testCloseRconexao() {
       RConnection con = new R().getRconexao();
       assertTrue(con.close());
    }
    
}
