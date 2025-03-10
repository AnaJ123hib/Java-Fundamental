import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = 0;
        int students = 0;
        int less40 = 0, btw40y50 = 0, btw50y60 = 0, more60 = 0;
        while (true){
            System.out.print("Enter number of students: ");
            try{
                students = scanner.nextInt();
                if(students > 50 || students < 0)
                    System.out.println("Number must be smaller than 50 and greater than 0");
                else
                    break;
            }
            catch (Exception e){
                System.out.println("Enter a number, not a charecter");
                scanner.nextLine();
            }
        }

        for(int i = 0; i < students; i++){
            System.out.print("Student weight: ");
            try{
                weight = scanner.nextInt();
                if(weight < 40)
                    less40++;
                else if (40 <=  weight && weight < 50)
                    btw40y50++;
                else if(50 <= weight && weight < 60)
                    btw50y60++;
                else
                    more60++;
            }
            catch (Exception e){
                System.out.println("It must be a integer number!");
                scanner.nextLine();
                i--;
            }
        }

        System.out.println("\nStudents under 40 kg: " + less40);
        System.out.println("Students between 40 and 50 kg: " + btw40y50);
        System.out.println("Students between 50 and 60 kg: " + btw50y60);
        System.out.println("Students over 60 kg: " + more60);
    }
}