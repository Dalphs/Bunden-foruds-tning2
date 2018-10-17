import java.util.Scanner;

public class Opgave8_9 {
    public static void main(String[] args) {

        //Vi opretter et Scanner objekt og deklarerer et todimensionelt array med characters der er 3 x 3 i størrelse
        Scanner input = new Scanner(System.in);
        char[][] table = new char[3][3];

        //Her fylder vi vores array table, så alle pladser indeholder et mellemrum
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = ' ';
            }
        }
        //Vi kører spillet som et for-loop da vi ved at alle pladser vil være fyldte efter 9 runder
        for (int i = 0; i < 9; i++) {
            //Vi printer table i konsollen så vi kan se hvor vi kan sætte x og 0, og vi lanver et linjeskift
            printTable(table);
            System.out.println();
            //Vi deklarerer to varible som vi beder brugeren indtast
            int row;
            int column;
            //Hvis i er et lige tal er det X tur, og vi sætter et X i den row og column brugeren har indtastet
            if (i % 2 == 0) {
                System.out.println("Enter a row for (0, 1, 2) for player X: ");
                row = input.nextInt();
                System.out.println("Enter a column for (0, 1, 2) for player X: ");
                column = input.nextInt();
                table[row][column] = 'X';
                //Hvis spillet slutter efter der er sat et X ved vi at X har vundet
                if (gameFinished(table)) {
                    printTable(table);
                    System.out.println("\nPlayer X Won!!!");
                    break;
                }
            } else {
                //Denne del fungerer på samme måde som delen opover dog med 0 i stedet for X
                System.out.println("Enter a row for (0, 1, 2) for player 0: ");
                row = input.nextInt();
                System.out.println("Enter a column for (0, 1, 2) for player 0: ");
                column = input.nextInt();
                table[row][column] = '0';
                if (gameFinished(table)) {
                    printTable(table);
                    System.out.println("\nPlayer 0 Won!!!");
                    break;
                }
            }
            //Hvis der efter 9 runder ikke er fundet en vinder er spillet endt uafgjort
            if (i == 8){
                printTable(table);
                System.out.println("\nIts a draw!!!");
            }

        }

    }

    //Denne metode udskriver table(spillepladen) i konsollen
    //Metoden udskriver vandrette streger efter hver enkelt række og laver lodrette streger langs kolonnerne
    public static void printTable(char[][] a) {
        System.out.print("-------------");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("\n%1c%2s%2c%2s%2c%2s%2c", '|', a[i][0], '|', a[i][1], '|', a[i][2], '|');
            System.out.print("\n-------------");
        }
    }

    public static boolean gameFinished(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            //Denne if-sætning kontrollere om der er 3 ens på en række eller kolonne, og det må ikke være mellemrum
            if ((((a[i][0] == a[i][1]) && (a[i][0] == a[i][2])) && a[i][0] != ' ') ||
                    ((a[0][i] == a[1][i]) && (a[0][i] == a[2][i])) && a[0][i] != ' ') {
                return true;
            }
        }
        //Denne if-sætning kontrollere om der er 3 ens på tværs af table, både fra oppe venstre til nede højre
        //Og fra nede venstre til oppe højre
        if (((a[0][0] == a[1][1] && a[0][0] == a[2][2]) && a[0][0] != ' ') ||
                ((a[0][2] == a[1][1] && a[0][2] == a[2][0]) && a[1][1] != ' ')) {
            return true;
        }

        return false;
    }
}