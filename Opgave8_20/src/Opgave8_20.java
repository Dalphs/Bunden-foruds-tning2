import java.util.Scanner;

public class Opgave8_20 {
    public static void main(String[] args) {
        //Vi opretter et scanner objekt og deklarere et Character array på 6X7 som fungeres som vores "spilleplade"
        Scanner input = new Scanner(System.in);
        char[][] table = new char[6][7];

        //Vi udfyler alle pladser i table med mellemrum og derefter udskirver vi det i konsollen
        //Vi laver også en counter som incrementer hver gang en tur er sluttet.
        //Det er denne counter der gør vi ved om det er rød eller guls tur
        fillTable(table);
        printTable(table);
        int counter = 0;

        //Dette loop kører så længe spillet ikke er færdigt
        while(!gameFinished(table)){
            //Som sagt bestemmer counteren hvis tur det er
            // Er counteren et lige tal er det røds tur og ulige tal så er det guls tur
            if(counter % 2 == 0){
                System.out.println("Drop a red disk at column (0-6): ");
                //Vi kalder vores dropDisk metode hvor vi fortæller hvilken række disken skal i
                // og derfter printer vi table så vi kan se den opdaterede spilleplade
                dropDisk(table, 'R',input.nextInt());
                printTable(table);
                //hvis spillet er færdig ved vi rød vandt fordi det er den sidste disk der er blevet lagt ned
                if(gameFinished(table)){
                    System.out.println("The red player won");
                }
                //Vi gør det samme som opover bare med gul
            } else{
                System.out.println("Drop a yellow disk at column (0-6): ");
                dropDisk(table, 'Y',input.nextInt());
                printTable(table);
                if(gameFinished(table)){
                    System.out.println("The yellow player won");
                }
            }
            //En tur er overstået og derfor incrementer vi counter så turen skifter til den anden farve
            counter++;
        }


    }

    //Denne metode udskriver table (vores spilleplade)
    public static void printTable(char[][] table){
        //Vi bruger nested for-loops hvilket gør at vi printer table ud så det først er række 0 der printes, derefter 1, så 2 osv.
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.printf("%-1c%-1c", '|', table[i][j]);
            }
            //Hver gang vi har udskrevet et felt laver vi en '|' for at adskille felterne på spillepladen
            System.out.println("|");
        }
        //Dette udskriver for at lave adskillelse mellem hver tur
        System.out.println("---------------");
    }

    //Den metode putter en brik ned i en bestemt række, og brikken lægger sig i bunden
    //Metoden skal både have at vide hvad spillerpladen hedder,
    // om den skal lægge en rød eller gul brik, og hvilken række den skal lægges i
    public static char[][] dropDisk(char[][] table, char user, int row){
        //for-loopet starter fra bunden af den specificerede row og går op ad
        for (int i = table.length - 1; i >= 0; i--) {
            //If sætningen fortæller om pladsen er optaget af en rød eller gul brik.
            //Er den optaget køre for-loopet en gang mere og tester feltet op over
            //Er feltet ledigt smider vi brikken ned
            if(table[i][row] != 'R' && table[i][row] != 'Y'){
                table[i][row] = user;
                return table;
            }
        }
        //Vi returnerer den opdaterede spilleplade
        return table;
    }

    //Denne metode fylder vores spilleplade med et mellemrum på hver plads
    public static void fillTable(char[][] table){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = ' ';
            }
        }
    }

    //Hvis der er enten 4 på stibe i en række eller kollonne returnerer metoden true
    //hvis der er fire påstribe på skrå returnerer metoden true
    public static boolean gameFinished(char[][] table){
        if(checkRow(table) || checkColumn(table) || checkMajor(table) || checkSub(table)){
            return true;
        }
        return false;
    }

    //Metoden tester om der er 4 på stribe vandret
    public static boolean checkRow(char[][] table){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length - 3; j++) {
                //Vi kører alle felter i gennem og hvis det første felt == de næste tre felter i rækken så returnerer metoden true
                //felter skal dog være forskellige fra mellemrum, ellers ville spillet slutte med det samme
                if(table[i][j] != ' ') {
                    if (table[i][j] == table[i][j + 1] && table[i][j] == table[i][j + 2] && table[i][j] == table[i][j + 3]) {
                        return true;
                    }
                }
            }
        }
        //Er der ikke 4 på stribe vandret returnerer metoden false
        return false;
    }

    //Denne metode kontrolerer om der er 4 på stribe lodret
    public static boolean checkColumn(char[][] table){
        for (int i = 0; i < table.length - 3; i++) {
            for (int j = 0; j < table[0].length; j++) {
                //Vi kører alle felter i gennem og hvis det første felt == de næste tre felter i kollonnen så returnerer metoden true
                //felter skal dog være forskellige fra mellemrum, ellers ville spillet slutte med det samme
                if (table[i][j] != ' ') {
                    if (table[i][j] == table[i + 1][j] && table[i][j] == table[i + 2][j] && table[i][j] == table[i + 3][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Metoden kontrolerer om der er fire på stribe på skrå fra oppe venstre mod nede højre
    public static boolean checkMajor(char[][] table){
        for (int i = 0; i < table.length - 3; i++) {
            for (int j = 0; j < table[0].length - 3; j++) {
                //Hvis det vilkårlige felt er det samme som de 3 felter skråt ned mod højre så returnerer metoden true
                //felter skal dog være forskellige fra mellemrum, ellers ville spillet slutte med det samme
                if (table[i][j] != ' ') {
                    if (table[i][j] == table[i + 1][j + 1] && table[i][j] == table[i + 2][j + 2] && table[i][j] == table[i + 3][j + 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Denne metode kontrollerer om der er 4 på stribe på skrå fra oppe højre til ned venstre
    public static boolean checkSub(char[][] table){
        for (int i = 0; i < table.length - 3; i++) {
            for (int j = table[0].length - 1; j > 2; j--) {
                //Hvis det vilkårlige felt er det samme som de 3 felter skråt ned mod venstre så returnerer metoden true
                //felter skal dog være forskellige fra mellemrum, ellers ville spillet slutte med det samme
                if (table[i][j] != ' ') {
                    if (table[i][j] == table[i + 1][j - 1] && table[i][j] == table[i + 2][j - 2] && table[i][j] == table[i + 3][j - 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
