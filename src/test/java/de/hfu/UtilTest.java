package de.hfu;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
    @Test
    public void testIstErstesHalbjahr() {
        final int eingabe = 3;
        final boolean sollWert = true;
        assertEquals(sollWert, Util.istErstesHalbjahr(eingabe));
    }

    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testZuNiedrigerMonat() {
        Util.istErstesHalbjahr(0);
    }

    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testZuHoherMonat() {
        Util.istErstesHalbjahr(15);
    }

    @Test
    public void testIstErstesHalbjahr2() {
        //zufällig ausgewählte Werte
        assertTrue(Util.istErstesHalbjahr(5));
        assertFalse(Util.istErstesHalbjahr(10));

        //Grenzwerte
        assertTrue(Util.istErstesHalbjahr(1));
        assertTrue(Util.istErstesHalbjahr(6));
        assertFalse(Util.istErstesHalbjahr(7));
        assertFalse(Util.istErstesHalbjahr(12));
    }
}
