import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Deklarering af 2 variable, som brugeren assigner senere
        int id;
        int choice;

        //Oprettelse af et scanner objekt
        Scanner input = new Scanner(System.in);

        //Initialisering af en boolean så et while-loop kommer til at køre dor evigt
        boolean runForever = true;

        //Oprettelse af et nyt Account objekt med 10 konti med 100 kroner hver
        Account list = new Account(new double[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100});

        //Dette while-loop kører for evigt da boolean variablen runForever ikke ændres
        while(runForever == true){
            //Brugeren angiver id, så vi ved hvilket index vi skal ændre i vores Account objekt
            System.out.println("\nEnter an id: ");
            id = input.nextInt();

            //printScreen og choice metoderne fra Interface klassen benyttes
            Interface.printScreen();
            choice = Interface.choice();

            //Dette while-loop kører hvis brugeren har indtastet 1, 2, eller 3.
            //Vælger brugeren 4 afsluttes dette while-loop, og det ydre while-loop starter forfra
            while(choice != 4){

                switch(choice) {
                    //Vælger brugeren 1, vises balancen ved at kalde getBalance metoden fra Account klassen på vores list objekt
                    case 1:
                        System.out.println("The balance is: " + list.getBalance(id));
                        break;
                    //Vælger brugeren 2, fratrækkes et beløb indtastet af brugeren ved at kalde withdraw metoden
                    //på vores list objekt
                    case 2:
                        System.out.println("Enter an amount to withdraw: ");
                        list.withdraw(id, input.nextDouble());
                        break;
                    //Vølger brugeren 3, indsættes et beløb indtastet af brugeren ved at kalde deposit metoden på vores list objekt
                    case 3:
                        System.out.println("Enter an amount to deposit: ");
                        double amount = input.nextDouble();
                        list.deposit(id, amount);
                        break;
                    //Denne case udskriver System error i tilfælde af der skulle ske en fejl i programmet
                    default:
                        System.out.println("System error");
                        break;
                }
                //Menuen udskirves i konsollen igen og brugeren kan vælge en ny handling
                Interface.printScreen();
                choice = Interface.choice();
            }
        }
    }
}
