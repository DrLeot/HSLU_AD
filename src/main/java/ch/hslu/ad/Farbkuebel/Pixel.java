package ch.hslu.ad.Farbkuebel;

public class Pixel {

    private final int x;
    private final int y;
    private Colours colour;

    public Pixel(final int x, final int y, final Colours colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Colours getColour() {
        return colour;
    }

    public void setColour(Colours colour) {
        this.colour = colour;
    }
}
