import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = ((int) Math.round(Math.random() * 100));
        int numberUser = 0;
        boolean guessCorrect = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t **Guessing game** ");
        for (int i = 0; i < 12; i++) {
            System.out.println();
            System.out.print("Enter a number: ");
            try{
                numberUser = scanner.nextInt();
                if(number < numberUser)
                    System.out.println("The number is smaller");
                else if(number > numberUser)
                    System.out.println("The number is greater");
                else{
                    guessCorrect = true;
                    if(1 <= i && i <= 3)
                        System.out.println("It was pure luck!");
                    else if (4 <= i && i <= 6)
                        System.out.println("You are good!");
                    else if (i == 7)
                        System.out.println("It's not bad");
                    else if(i == 8)
                        System.out.println("It can be improved");
                    else
                        System.out.println("You look so bad!!!");
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Enter a number please, not a character!!");
                scanner.nextLine();
            }

        }

        if(!guessCorrect)
            System.out.println("Bad look, the number is " + number);
    }
}