
package com.datamy.main.r;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HelloWorldTest {
    
    public HelloWorldTest() {
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
     * Test of helloFulano method, of class HelloWorld.
     */
    @Test
    public void testHelloFulano() throws Exception {
        HelloWorld hl = new HelloWorld();
        assertNull(hl.helloFulano("yuri"));
        System.out.println(hl.helloFulano("yuri"));
        
    }
    
}
