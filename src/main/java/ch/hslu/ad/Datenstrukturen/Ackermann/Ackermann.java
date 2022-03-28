package ch.hslu.ad.Datenstrukturen.Ackermann;

public final class Ackermann {

    public static long ack(int n, long m){
        if ( n == 0 ){
            return m + 1;
        }
        if ( m == 0 ){
            return ack( n - 1, 1 );
        }

        return ack( n - 1, ack(n, m - 1) );
    }
}
