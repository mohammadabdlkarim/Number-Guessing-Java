package numberGuessing;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class numGuess {
    private static int number;
    private static int attempts;
    private static final int WRONG_ATTEMPTS = 5;

    private static int generateNumber(){
        number = (int)(Math.random() * 100);
        return number;
    }

    private static boolean outOfAttempts(){
        if(attempts >= WRONG_ATTEMPTS)
            return true;
        return false;
    }

    private static void resetAttempts(){
        attempts = 0;
    }

    private static int getRemainingAttempts(){
        return WRONG_ATTEMPTS - attempts;
    }

    private static void checkNumberGuess(int guess){
        if(guess > number)
            System.out.println("Your guess is bigger than the number.");
        else
            System.out.println("Your guess is smaller than the number.");
    }

    public static void playGame() {
        generateNumber();
        String answer = "";
        int guess;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Make a guess.");
            System.out.print("Your guess: ");
            try{
                guess = input.nextInt();
            }catch(InputMismatchException ex){
                try{
                    System.out.println("You should enter a number.");
                    input.nextLine();
                    guess = input.nextInt();
                }catch(InputMismatchException exception){
                    System.out.println("You inserted two wrong characters, you lose!");
                    break;
                }
            }
            if(guess == number){
                System.out.println("Your guess was right.");
                System.out.println("Do you want to Play again?");
                answer = input.next();
                resetAttempts();
            }
            else{
                ++attempts;
                if(outOfAttempts()) {
                    System.out.println("Oops you are out of attempts.");
                    System.out.println("Do you want to play again?");
                    answer = input.next();
                    resetAttempts();
                }
                else {
                    checkNumberGuess(guess);
                    System.out.println("Remaining attempts: " + getRemainingAttempts());
                }
            }
        }while(!answer.toLowerCase(Locale.ROOT).equals("no"));
        System.out.println("Hope you enjoyed.");
    }

}
