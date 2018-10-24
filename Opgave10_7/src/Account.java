public class Account {
    //Klassevariabel
    private double[] balance = new double[0];

    //No-arg constructor
    Account(){

    }

    //Constructor der tager imod et double array
    Account(double[] newBalance){
        balance = newBalance;
    }

    //Metode til at modtage balancen på givne index i klassens balance array
    public double getBalance(int id) {
        return balance[id];
    }

    //Metode til at hæve et vilkårligt beløb fra et givent index i klassen balance array
    public void withdraw(int id, double amount){
        if(balance[id] > amount) {
            balance[id] -= amount;
        } else{
            System.out.println("Not enough money in the account");
        }
    }

    //Metode til at indsætte et vilkårligt beløb på et givent index i klassens balance array
    public void deposit(int id, double amount){
        balance[id] += amount;
    }
}