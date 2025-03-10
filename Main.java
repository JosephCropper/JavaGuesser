//Main.java
//Simple rng guesser

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static Random rand = new Random();
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        boolean contnue = true;
        int input = 9;

        //End initialize Core
        while (contnue) {

            System.out.println("\n\n////////////////////////////////////\n -- Random Guesser -- \n");
            System.out.println("0) Exit\n" +
                    "1) Human Guesser\n" +
                    "2) Computer Guesser"
            );



            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input type|");
                scan.nextLine();
                input = 909;
            }


            //End Starting input Core

            switch (input) {
                case 0:
                    System.out.println("Exiting...");
                    contnue = false;
                    break;

                case 1:
                    humanGuesser();
                    break;

                case 2:
                    boolean loopCheck = true;
                    while (loopCheck) {

                        System.out.println("Number to be guessed (0 - 100): ");
                        try {
                            input = scan.nextInt();
                            if (input >= 0 && input <= 100) {
                                computerGuesser(input);
                                loopCheck = false;
                            }
                        } catch (Exception e) {
                            System.err.println("Incorrect input type|");
                            scan.nextLine();
                        }
                    }

            }//End Switch
        }//End While contnue
    }//end main

    public static void humanGuesser(){
        int randomNum = rand.nextInt(101);
        int input = -1; int count = 0;
        while (input != randomNum){
            System.out.println("Guess Number: ");
            try{
                input = scan.nextInt();
                count++;
            }
            catch (InputMismatchException e){
                System.err.println("Incorrect input type|");
                scan.nextLine();
            }
            if (input > randomNum){
                System.out.println("<<too high>>");
            }
            else if (input < randomNum){
                System.out.println(">>too low<<");
            }
        }

        System.out.println("You got it! the number was: " + randomNum + ".\n" +
                "It took you " + count + " tries.");
    } // end human guesser

    public static void computerGuesser(int number){
        int min = 0; int max = 100; int guess = -1; int count = 0;
        while (guess != number){
            guess = ((max+min)/2);
            System.out.println("Guessing: " + guess);
            count++;
            if (guess > number){
                System.out.println("<<too high>>");
                max = guess;
            }
            else if (guess < number){
                System.out.println(">>too low<<");
                min = guess;
            }
        }
        System.out.println("The number was: " + number + ".\n" +
                "It took the computer " + count + " tries.");
    } // end comp guesser
}
