package com.codeway;

import java.util.*;

public class NumberGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalAttempts = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Number Game!");

        boolean playAgain = true;
        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            int maxAttempts = 5;

            System.out.println("I have selected a number between 1 and 100. Can you guess what it is?");

            do
            {
                try 
                {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;
                    totalAttempts++;

                    if (userGuess == numberToGuess) 
                    {
                        System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts!");
                        guessedCorrectly = true;
                    } 
                    else if (userGuess < numberToGuess) 
                    {
                        System.out.println("Too low! Try again.");
                    } 
                    else 
                    {
                        System.out.println("Too high! Try again.");
                    }
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // clear the invalid input
                }
            }while (!guessedCorrectly && attempts < maxAttempts);

            if (!guessedCorrectly) 
            {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) 
            {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing the Number Game!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total attempts made: " + totalAttempts);

        scanner.close();
    }
}
