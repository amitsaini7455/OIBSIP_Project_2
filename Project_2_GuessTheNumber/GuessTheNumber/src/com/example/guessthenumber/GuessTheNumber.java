package com.example.guessthenumber;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRounds = 3;  
        int maxAttempts = 5;  
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("You have " + maxRounds + " rounds to play.");
        
        for (int round = 1; round <= maxRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); 
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1) * 10;  
                    hasGuessedCorrectly = true;
                    break;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was " + numberToGuess);
            }

            System.out.println("Current score: " + score);
        }

        System.out.println("\nGame Over!");
        System.out.println("Your final score is: " + score);
        scanner.close();
    }
}
