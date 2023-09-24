package NumberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    static Scanner scan = new Scanner(System.in);
    static int randomnumber = getRandomnumber();
    static int guess;
    static int score=0;

    static int getRandomnumber(){
        int min = 1;
        int max = 100;
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }

    static void game(){
        boolean playagain;
        System.out.println("Random number guessing game");
        System.out.println("Guess number between 1 & 100");
        System.out.println("You have 5 tries to guess the correct answer");
        do {
            for(int i=1;i<=5;i++) {
                System.out.println("Enter Guess: ");
                guess = scan.nextInt();
                if (randomnumber == guess) {
                    System.out.println("Correct Answer!");
                    score+=5;
                    System.out.println("Your score is "+ score);
                    break;
                } else {
                    if(guess<randomnumber){
                        System.out.println("Too low!");
                        System.out.println();
                        --score;
                    }
                    else{
                        System.out.println("Too high!");
                        System.out.println();
                        --score;
                    }
                }
            }
            System.out.println("The random number was "+randomnumber);
            System.out.println("Do you want to play another round?(Y/N)");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if(option.equals("Y") || option.equals("y")) {
                playagain=true;
                randomnumber = getRandomnumber();
            }
            else{
                playagain=false;
                System.out.println("Thanks For playing!");
            }
        }while (playagain==true);
    }

    public static void main(String[] args) {
        game();
    }
}