public class Opgave6_26 {
    public static void main(String[] args) {

        //Count tæller antallet af plindrom-primtal og tester er det tal vi tester
        int count = 0;
        int tester = 2;
        //Denne konstant bestemmer antallet af tal før vi skifter linje i konsollen
        final int NUMBER_OF_LINES_PER_LINE = 10;

        while(count < 120){
            //Hvis tester er både et palindrom og et primtal så printer vi tester i konsollen
            if(isPalindrome(tester) && isPrime(tester)) {
                //Count tæller op hver gang et tal er både et palindrom og et primtal
                //Så hvis counter % 10 == 0 betyder det at vi har 10 tal på en linje
                //og derfor laver vi et linjeskift inden vi printer næste linje
                if (count % NUMBER_OF_LINES_PER_LINE == 0) {
                    System.out.print("\n" + tester + " ");
                } else {
                    System.out.print(tester + " ");
                }
                //Counteren incrementer med 1 hver gang et tal er både et palindrom og et primtal
                count++;
            }
            //tester incrementer med 1 hver gang vi loopet har kørt, så vi tester et nyt tal
            tester++;
        }

    }
    //Denne metode tester om tallet n er et primtal
    public static boolean isPrime (int n){
        for (int i = 2; i <= n / 2 ; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    //Denne metode tester om tallet n er et palindrom
    public static boolean isPalindrome(int n){
        int divisor = 1;
        int test = n;
        //I denne løkke finder vi ud af hvor mange cifre der er i tallet n.
        //Hvis der er 3 cifre ender divisor på 100 er der 4 ender den på 1000 og så videre
        while (test >= 10){
            test = test / 10;
            divisor = divisor * 10;
        }
        int low = n;
        int ceil = divisor;
        //I dette for-loop finder extracter vi det første tal og det sidste tal i n og finder ud af om de er ens
        //Er de ikke ens returnere metoden false
        for (int i = 1; i < ceil; i *= 10)  {
            if((n / divisor) % 10 == low % 10){
                divisor = divisor / 10;
                low = low / 10;

            } else{
                return false;
            }
        }
        return true;
    }

}
