package ch.hslu.ad.Algorithmen.Automaten;

public final class Language {
    public static final int NOTFOUNDINDEX = -1;

    /**
     * Searches a for the Word "ANANAS"
     * @param a the Input
     * @return beginn of the occurance
     */
    public static int stateSearch(final String a){
        int i = 0;
        String state = "";

        do {
            switch (state){
                case "":
                    if (a.charAt(i) == 'A'){
                        state = "A";
                    }
                    break;
                case "A":
                    if (a.charAt(i) == 'N') {
                        state = "AN";
                    }
                    else if (a.charAt(i) == 'A') {
                        state = "A";
                    }
                    else {
                        state = "";
                    }
                    break;
                case "AN":
                    if (a.charAt(i) == 'A') {
                        state = "ANA";
                    }
                    else {
                        state = "";
                    }
                    break;
                case "ANA":
                    if (a.charAt(i) == 'N') {
                        state = "ANAN";
                    }
                    else if (a.charAt(i) == 'A') {
                        state = "A";
                    }
                    else {
                        state = "";
                    }
                    break;
                case "ANAN":
                    if (a.charAt(i) == 'A') {
                        state = "ANANA";
                    }
                    else if (a.charAt(i) == 'N') {
                        state = "ANA";
                    }
                    else {
                        state = "";
                    }
                    break;
                case "ANANA":
                    if (a.charAt(i) == 'S') {
                        state = "ANANAS";
                    }
                    else if (a.charAt(i) == 'A') {
                        state = "A";
                    }
                    else if (a.charAt(i) == 'N') {
                        state = "ANAN";
                    }
                    else {
                        state = "";
                    }
                    break;
                default:
                    return NOTFOUNDINDEX;
            }
            i++;
        }while (!(state.equals("ANANAS")) && (i < a.length()));
        if(state.equals("ANANAS")){
            return (i - "ANANAS".length());
        }
        return NOTFOUNDINDEX;
    }

    public static boolean isWordLanguage(final String word){

        char[] wordArray = word.toCharArray();
        int zeroCounter = 0;
        int oneCounter = 0;

        if(wordArray[0] != '0' || wordArray[wordArray.length - 1] != '0'){
            return false;
        }

        for(int i = 0; i <= wordArray.length - 1; i++){
            switch (wordArray[i]){
                case '0':
                    if(zeroCounter > 0) { // we've got two subsequent zeros
                        return false;
                    }
                    else if(oneCounter != 0 && (oneCounter % 2) != 1) { // even group of ones before zero
                        return false;
                    }
                    oneCounter = 0;
                    zeroCounter++;

                    break;
                case '1':
                    zeroCounter = 0;
                    oneCounter++;

                    break;
                default: // invalid char
                    return false;

            }


        }


        return !(oneCounter != 0 && (oneCounter % 2) <= 1);
    }
}
