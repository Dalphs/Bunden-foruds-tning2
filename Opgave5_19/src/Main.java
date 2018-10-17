public class Main {

    public static void main(String[] args) {

        // Pyramiden er teknisk set en kasse, hvor felterne der ikke består af tal skal være blanke.
        // Derfor initalisere jeg en String der indeholder et mellemrum.
        // Hvis de blanke felter ikke var der ville alle talene starte i venstre side og ikke i  midten.
        String space = " ";

        //Jeg laver et for-loop der bestemmer hvor højt der skal tælles op i nederste linje af pyramiden.
        //i bestemmer hvor stor pyramiden skal være.
        for (int i = 0; i < 8 ; i++) {
            int number = 1;
            int j = i +1;
            int k = i;

            //Dette while-loop udskriver mellemrum for det antal tal der ikke er i rækken
            while(k < 8) {
                System.out.printf("%4s", space);
                System.out.print(" ");
                k++;
            }

            //Dette while-loop udskriver tallene fra 1 - 2187 når i = 8.
            while (j > 0){
                System.out.printf("%4d", number);
                System.out.print(" ");
                j--;
                number = number *3;
            }
            number = number / 3;

            //Dette while-loop udskriver tallene fra 729 - 1 når i = 8
            while (j < i){
                number = number / 3;
                System.out.printf("%4d", number);
                System.out.print(" ");
                j++;
            }
            //Denne linje laver linjeskift i konsollen
            System.out.println("");
        }
    }
}
