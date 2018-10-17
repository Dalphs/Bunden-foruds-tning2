public class Opgave6_32 {
    public static void main(String[] args) {
        //Disse variable stiger hvergang den givne spiller har vundet
        int userWins = 0;
        int computerWins = 0;

        //For-loopet kører spillet 15.000 gange
        for (int i = 0; i < 15000 ; i++) {
            //Vi kaster vores terning 2 gange hver gang for-loopet starter og udrenger summen af kastene
            int throw1 = dice();
            int throw2 = dice();
            int sum = throw1 + throw2;

            //Hvis summen er 2, 3 eller 12 vinder computer og incrementer computerWins
            //Hvis summen er 7 eller 11 vinder spilleren og incremnter userWins
            //Bliver summen noget andet spiller man indtil der slås 7 og så vinder computeren og incrementer computerWins
            //Bliver summen slået igen inden der slås 7 vinder spilleren og userWins incrementes
            if (sum == 2 || sum == 3 || sum == 12) {
                computerWins++;
            } else if (sum == 7 || sum == 11) {
                userWins++;
            } else {
                int newsum = 0;
                do {
                    int newthrow1 = dice();
                    int newthrow2 = dice();
                    newsum = newthrow1 + newthrow2;
                } while (sum != newsum && newsum != 7);
                if (newsum == 7) {
                    computerWins++;
                } else {
                    userWins++;
                }
            }
        }
        //Vi printer userWins og computerWins så vi kan se hvor mange gange hver har vundet af de 15000 spil
        System.out.println("User wins: " + userWins);
        System.out.println("Computer wins: " + computerWins);
    }

    //Denne metode giver returnerer et tilfældigt tal mellem 1-6 og er derved en terning
    public static int dice () {
        int eyes = (int) (Math.random() * 6) + 1;
        return eyes;
    }

}

