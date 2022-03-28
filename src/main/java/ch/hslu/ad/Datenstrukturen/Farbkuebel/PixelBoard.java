package ch.hslu.ad.Datenstrukturen.Farbkuebel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PixelBoard {

    private static final Logger LOG = LogManager.getLogger(PixelBoard.class);
    private List<Pixel> pixels = new ArrayList<>();

    public PixelBoard(int width, int height, String startValues){
        if (width*height != startValues.length()){
            throw new ArithmeticException("Die Stringlänge muss gleich der Brettgrösse sein");
        }

        int currentX = 1;
        int currentY = 1;
        for (char item : startValues.toCharArray()) {
            Colours colour = (item == '0') ? Colours.BLACK : Colours.WHITE;
            pixels.add(new Pixel(currentX,currentY,colour));

            if (currentX >= width){
                currentX = 1;
                currentY++;
            }else{
                currentX++;
            }
        }
    }

    public void colorArea(final int x,
                                 final int y,
                                 final Colours fillColor,
                                 final Colours outsideColor) {
        Colours actualColor;
        actualColor = getActualColor(x, y);
        if ((!actualColor.equals(outsideColor)) && (!actualColor.equals(fillColor))) {
            colorPixel(x, y, fillColor);
            colorArea(x + 1, y, fillColor, outsideColor);
            colorArea(x, y + 1, fillColor, outsideColor);
            colorArea(x - 1, y, fillColor, outsideColor);
            colorArea(x, y - 1, fillColor, outsideColor);
        }
    }

    public Pixel getPixel(final int x, final int y){
        for (Pixel pixel:pixels) {
            if (pixel.getX() == x && pixel.getY() == y){
                return pixel;
            }
        }
        return null;
    }

    public void colorPixel(int x, int y, Colours fillColor) {
        LOG.debug("[x:{} y:{}] -> {}",x,y,fillColor.getColourCode());
        getPixel(x,y).setColour(fillColor);
    }

    public Colours getActualColor(int x, int y) {
        return getPixel(x,y).getColour();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pixel pixel:pixels) {
            stringBuilder.append(pixel.getColour().getColourCode());
        }
        return stringBuilder.toString();
    }
}
