package com.coderscampus.assignment1;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main (String [] args) {

        //Setup of Scanner object
        Scanner input = new Scanner(System.in);

        //variables
        //not 100% sure on use of final ints
        final int MAX_NUMBER = 100; //This number is INCLUSIVE
        final int MIN_NUMBER = 1; //This number is INCLUSIVE
        int numberOfGuesses = 5;
        int playerGuessNumber = 0;
        int randomNumber;
        int playerGuess;

        //setup of random number object, and assignment max limit
        Random random = new Random();
        randomNumber = random.nextInt(MAX_NUMBER)+1;

        //the below code line was added for testing purposes only, and
        //can be un-commented to allow an output of the random number

        /*
        System.out.println(randomNumber);
        */

        System.out.println("RULES:");
        System.out.println("You have " + numberOfGuesses + " guesses");
        System.out.println("You need to guess a number between " +
                MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.println("The random number can be INCLUSIVE");
        System.out.println("This means, it can be " + MIN_NUMBER +
                ", and it can be " + MAX_NUMBER);
        System.out.println("A guess outside of these numbers does NOT count towards " +
                "your guess count");
        System.out.println("GOODLUCK!");

        //Start of while loop, looping to value set in numberOfGuesses (5)
        //for loop allows guesses outside of the range to not affect the while counter
        while (playerGuessNumber < numberOfGuesses) {
            System.out.println("Please pick a number between " + MIN_NUMBER + " and "
                    + MAX_NUMBER);
            playerGuess = input.nextInt();

            if (playerGuess < MIN_NUMBER || playerGuess > MAX_NUMBER) {
                System.out.println("Your guess is not between " + MIN_NUMBER + " and " +
                        MAX_NUMBER + ", please try again");
            }
            else if (playerGuess > randomNumber) {
                System.out.println("Please pick a lower number");
                playerGuessNumber++;
            }
            else if(playerGuess < randomNumber) {
                System.out.println("Please pick a higher number");
                playerGuessNumber++;
            }
            else {
                System.out.println("Your guess of " + playerGuess + " is correct!");
                break;
            }
        }
        if (playerGuessNumber == numberOfGuesses) {
            System.out.println("You lose!");
            System.out.println("The number to guess was: " + randomNumber);
        }
        input.close();
    }
}