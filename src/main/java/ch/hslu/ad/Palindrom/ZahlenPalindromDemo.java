package ch.hslu.ad.Palindrom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ZahlenPalindromDemo {

    private static final Logger LOG = LogManager.getLogger(ZahlenPalindromDemo.class);

    public static void main(final String[] args){
        LOG.debug(isNumberPalindrom(7,8227228));
        LOG.debug(isNumberPalindrom(1,1));
        LOG.debug(isNumberPalindrom(5,12321));
        LOG.debug(isNumberPalindrom(5,12322));
        LOG.debug("--------");
        LOG.debug("The next Palindrom from 193 is {}", getNextPalindrom(3,193));
    }

    public static int getNextPalindrom(final int n, int number){
        boolean isPalindrom;
        do {
            isPalindrom = isNumberPalindrom(n, number);
            if(!isPalindrom){
                number++;
            }
        }while (!isPalindrom);

        return number;
    }

    public static boolean isNumberPalindrom(final int n, int number){
        int numberForward = number;
        int numberReversed = 0;
        int tmp;

        if((int)Math.log10(number)+1 != n){ // n und anzahl stellen von number müssen übereinstimmen
            return false;
        }

        while(numberForward>0){
            tmp = numberForward%10; // letzte Ziffer holen
            numberReversed = (numberReversed*10) + tmp;
            numberForward = numberForward/10;
        }

        return number == numberReversed;
    }
}
