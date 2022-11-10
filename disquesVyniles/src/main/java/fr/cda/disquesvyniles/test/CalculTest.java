package fr.cda.disquesvyniles.test;

import junit.framework.TestCase;
import org.junit.Test;


public class CalculTest extends TestCase{

    @Test
    public void testM(){
        assertEquals(4, Calcul.multi(2,2));
    }
    @Test
    public void testAdd(){
        assertEquals(4, Calcul.add(2,2));
    }
    @Test
    public void testSous(){
        assertEquals(1, Calcul.sous(3,2));
    }
}
