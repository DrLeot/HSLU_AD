package ch.hslu.ad.Datenstrukturen.Farbkuebel;

public enum Colours {

    BLACK('0'),
    WHITE('1'),
    GREY('2');

    private final char colourCode;

    Colours(char colourCode) {
        this.colourCode = colourCode;
    }

    public char getColourCode(){
        return this.colourCode;
    }
}
