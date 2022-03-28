package ch.hslu.ad.Datenstrukturen.Palindrom;

import org.junit.jupiter.api.Test;

import static ch.hslu.ad.Datenstrukturen.Palindrom.ZahlenPalindromDemo.isNumberPalindrom;
import static org.junit.jupiter.api.Assertions.*;

class ZahlenPalindromDemoTest {


    @Test
    public void testNumberPalindromUsual(){
        assertTrue(isNumberPalindrom(7,8227228));
    }

    @Test
    public void testNumberPalindromWrong(){
        assertFalse(isNumberPalindrom(3,120));
    }

    @Test
    public void testDigitPalindrom(){
        assertTrue(isNumberPalindrom(1,5));
    }
}