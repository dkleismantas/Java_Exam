package lt.techin.exam;

import java.util.ArrayList;
import java.util.Random;

public class Exercises {


    /*
     * Metodas parodo ar iš duotų trijų atkarpų (įvedami jų ilgiai) galima sudaryti trikampį.
     */
    public static boolean isTriangleValid(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }



    /* Metodas spausdina  nelyginius skaičius nuo pateikto skaičiaus 'number' iki 1
     * pvz. number = 8 =>
     * 7
     * 5
     * 3
     * 1
     *  */
    public static void printOddNumbers(int number) {
        for (int i = number; i >= 1; i--) {
            if ((double)i % 2 != 0) {
            System.out.println(i);}

        }
    }



    /* Paskaičiuoti kiek masyve yra skaičių didesnių nei skaičius 'number'
     * Pvz. array =  {5, 2, 4, 1} number = 3 => 2
     */
    public static int countLargerThanNumber(int[] array, int number) {
        int count = 0;
        for (int i : array) {
            if (i > number) {
                count++;
            }
        }

        return count;
    }


    /* Surasti mažiausią skaičių ArrayListe
     * Pvz {6.7, 3.5, 8.2, 4.3} => 8.2
     */
    public static double findSmallest(ArrayList<Double> numbers) {
        double min = numbers.getFirst();
        for (Double i : numbers) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    /* Paskaičiuoti kiek ArrayListe yra stringų, kuriuose yra žodis word
        pvz: {"iphone 12", "IPHONE 12", "samsung s23"} word = "iphone" => 2
     */
    public static int countStringsContainingWord(ArrayList<String> strings, String word) {
        int cont = 0;

        for (String i : strings) {
            if (i.toLowerCase().contains(word.toLowerCase())) {
                cont++;
            }
        }
        return cont;
    }


    /* Metodas generuoja bet kokį atsitiktinį (nesikartojanti kviečiant metodą daug kartų) email adresą */
    public static String generateRandomEmail(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString()+"@gmail.com";
    }
}
