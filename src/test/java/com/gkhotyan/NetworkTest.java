package com.gkhotyan;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * @author georgiy.hotiyan
 */
public class NetworkTest {

    @Test
    public void connectAndQueryTest() {
        Network network = new Network(5);
        network.connect(1 , 2);
        assertTrue(network.query(1, 2));

        network.connect(1 , 2);
        network.connect(2 , 4);
        assertTrue(network.query(1, 4));

        assertFalse(network.query(1, 3));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testWrongInitialization() {
        Network network = new Network(-1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testWrongConnection() {
        Network network = new Network(5);
        network.connect(1, 6);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testWrongQuery() {
        Network network = new Network(5);
        network.connect(1, 2);
        network.connect(3, 4);
        network.query(3 , 6);
    }

}
