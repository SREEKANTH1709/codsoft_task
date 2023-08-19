import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int gameContinue = 1, randomNumber = 0, totalGuesses = 1, totalGuessesLeft = 5, guess = 0, score = 0, totalScore = 0;
        
        do {
            randomNumber = random.nextInt(100) + 1;
            System.out.println("A random number is now generated below 100");
            
            do {
                System.out.print("Guess number " + totalGuesses + ": ");
                guess = scanner.nextInt();
                
                if (guess == randomNumber) {
                    switch (totalGuesses) {
                        case 1:
                            score = 100;
                            break;
                        case 2:
                            score = 75;
                            break;
                        case 3:
                            score = 50;
                            break;
                        case 4:
                            score = 25;
                            break;
                        case 5:
                            score = 10;
                            break;
                        default:
                            score = 0;
                            break;
                    }
                    System.out.println("Congratulations, You have guessed it right!");
                    System.out.println("Your score is " + score);
                    totalScore += score;
                    break;
                } else if (guess < randomNumber) {
                    if (totalGuesses == totalGuessesLeft - 1) {
                        System.out.println("\nLast chance!!! The number is bigger than this one.");
                    } else if (totalGuesses < totalGuessesLeft - 1) {
                        System.out.println("the number is bigger than this one.");
                    }
                    totalGuesses++;
                } else if (guess > randomNumber) {
                    if (totalGuesses == totalGuessesLeft - 1) {
                        System.out.println("\nLast chance!!! The number is smaller than this one.");
                    } else if (totalGuesses < totalGuessesLeft - 1) {
                        System.out.println("the number is smaller than this one.");
                    }
                    totalGuesses++;
                }
                System.out.println(totalGuessesLeft - totalGuesses + " guesses left.");
            } while (totalGuesses <= totalGuessesLeft);
            
            if (totalGuesses == totalGuessesLeft + 1) {
                System.out.println("\nLooks like you have run out of chances!!!");
                System.out.println("The correct number was: " + randomNumber);
            }
            
            System.out.println("\nDo you wish to play again?");
            System.out.print("If yes enter the previous random number:\t");
            System.out.print(randomNumber);
            System.out.print("\nTo exit type anything else!\t");
            gameContinue = scanner.nextInt();
            
            if (gameContinue == randomNumber) {
                System.out.println();
                totalGuesses = 1;
                System.out.println("---------Starting a New Game for you-----------\n");
            } else {
                System.out.println("\nThank You!");
                System.out.println("Your total score was: " + totalScore + "\n");
            }
        } while (gameContinue != 0);
        
        scanner.close();
    }
}
