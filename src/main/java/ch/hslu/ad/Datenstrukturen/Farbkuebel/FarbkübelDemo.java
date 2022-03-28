package ch.hslu.ad.Datenstrukturen.Farbkuebel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FarbkübelDemo {

    private static final Logger LOG = LogManager.getLogger(FarbkübelDemo.class);

    public static void main(final String[] args){
        PixelBoard pixelBoard = new PixelBoard(11,10,"00000000000011100000000111110011001111111110010011111100100100000001001111000010000010000111111100000000000000");
        LOG.debug(pixelBoard.toString());
        pixelBoard.colorArea(4,3,Colours.GREY,Colours.BLACK);
        LOG.debug(pixelBoard.toString());
    }

}
