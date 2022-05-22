package ch.hslu.ad.Algorithmen.Automaten;

public final class KMP {

    public static int kmpSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        int indexSearchWord = 0;
        int indexPattern = 0;
        int[] next= initNext(p);

        do{
            if((indexPattern == -1) || (a.charAt(indexSearchWord) == p.charAt(indexPattern))) {
                indexSearchWord++; // process next character
                indexPattern++;
            } else{
                indexPattern = next[indexPattern]; // goto next state
            }
        } while((indexPattern < m) && (indexSearchWord < n));
        if(indexPattern == m) {
            return(indexSearchWord -m); // p found: index to position in a
        } else{
            return-1; // p not found
        }
    }

    private static int[] initNext(final String p) {
        final int m = p.length();
        final int[] next= new int[m];
        int i = 0;
        int j = -1;

        next[0] = -1;

        do{
            if((j == -1) || (p.charAt(i) == p.charAt(j))) {
                i++;
                j++;
                next[i] = j;
            } else{
                j = next[j];
            }
        } while(i < (m -1));
        return next;
    }
}