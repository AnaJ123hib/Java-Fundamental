import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static String menu(){
        String text= "";
        text += "**MENU ** \n";
        text += "1. Halla la \n ";
        text += "2. Graficar un numero \n";
        text += "3. Salir \n";

        return text;
    }
    static int suma(int x, int n){
        int numerador = 9000 * (3 * x + 5 - n);;
        return numerador;
    }
    static void grafico(int h){
        int l = h/2;
        for (int i = 1; i <= h; i++ ){
            for (int j = 1; j <= l; j++ ){
                if(i == 1 || i == l || i == h){
                    System.out.print("* ");
                }
                else if(j == 1 && i < l ){
                    System.out.print("* ");
                }
                else if(j == l ){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println("\n");
        }

    }
    public static void main(String[] args) {
        String option = "";
        while(!option.equals("3")){
            System.out.println(menu());
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextLine();

            switch (option){
                case "1":
                    System.out.print("valor de x [6 – 9]: ");
                    int x = scanner.nextInt();if(x >= 6 && x <= 7){
                    System.out.println("Cantidad e términos n [3 – 8]: ");
                    int n = scanner.nextInt();
                    if(n >= 3 && n <= 8){
                        System.out.println("Serie: " + suma(x,n));
                    }
                }
                    continue;
                case "2":
                    System.out.print("Altura del número : ");
                    int n = scanner.nextInt();
                    grafico(n);
                    break;
            }
        }
    }
}
