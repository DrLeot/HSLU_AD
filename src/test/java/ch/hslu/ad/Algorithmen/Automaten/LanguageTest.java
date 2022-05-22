package ch.hslu.ad.Algorithmen.Automaten;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageTest {


    @Test
    public void testLanguageWrongStart(){
        assertFalse(Language.isWordLanguage("111"));
    }

    @Test
    public void testLanguageWrongEnd(){
        assertFalse(Language.isWordLanguage("0111"));
    }

    @Test
    public void testLanguageWrong(){
        assertFalse(Language.isWordLanguage("011110"));
        assertFalse(Language.isWordLanguage("001110"));
        assertFalse(Language.isWordLanguage("01110010"));
        assertFalse(Language.isWordLanguage("01011110"));
        assertFalse(Language.isWordLanguage("01011010"));

    }

    @Test
    public void testLanguageRight(){
        assertTrue(Language.isWordLanguage("0"));
        assertTrue(Language.isWordLanguage("010"));
        assertTrue(Language.isWordLanguage("01110"));
        assertTrue(Language.isWordLanguage("0111010"));
        assertTrue(Language.isWordLanguage("0101110"));
        assertTrue(Language.isWordLanguage("0101010"));
    }

    @Test
    public void testStateSearchCorrectWord(){
        assertEquals(1, Language.stateSearch("FANANASF"));
        assertEquals(0, Language.stateSearch("ANANAS"));
        assertEquals(3, Language.stateSearch("FFFANANAS"));
    }

    @Test
    public void testStateNotFound(){
        assertEquals(-1, Language.stateSearch("AFFE"));
        assertEquals(-1, Language.stateSearch("MEIER"));
        assertEquals(-1, Language.stateSearch("ANNANNAS"));

        assertEquals(-1, Language.stateSearch("AXNANAS"));
        assertEquals(-1, Language.stateSearch("ANXANAS"));
        assertEquals(-1, Language.stateSearch("ANAXNAS"));
        assertEquals(-1, Language.stateSearch("ANANXAS"));
        assertEquals(-1, Language.stateSearch("ANANAXS"));
    }

}