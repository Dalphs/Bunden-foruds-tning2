import java.util.Scanner;

public class Interface{

    Interface(){ }

    //Denne metode udkriver hovedmenuen i automaten
    public static void printScreen(){

        System.out.println("\nMain Menu");
        System.out.println("1: Check balance");
        System.out.println("2: Withtdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Exit");
        System.out.println("Enter a choice:");
    }

    //Denne metode tager imod input fra brugeren
    public static int choice(){
        int choice;
        Scanner input = new Scanner(System.in);

        choice = input.nextInt();
        //Hvis brugeren indtaster et valg der ikke er repræsenteret i menuen,
        //bedes brugeren indtaste et nyt valg
        while(choice < 1 || choice > 4){
            System.out.println("\nInvalid input");
            System.out.println();
            printScreen();

            choice = input.nextInt();
        }
        return choice;
    }
}
