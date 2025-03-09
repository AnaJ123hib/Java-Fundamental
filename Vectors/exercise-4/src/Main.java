import java.util.Arrays;
import java.util.Collections;

public class Main {
    static  void MayorVenta(int[] ventas19, int[] ventas20){
        int maxVenta19 = 0;
        int maxVenta20 = 0;
        for(int i = 0; i < ventas19.length; i++){
            if(ventas19[i] > maxVenta19){
                maxVenta19 = ventas19[i];
            }
        }

        maxVenta20 = Arrays.stream(ventas20).max().getAsInt();
        if(maxVenta19 > maxVenta20)
            System.out.println("El año donde se realizó la mayor venta fue en el 2019");
        else if(maxVenta19 < maxVenta20)
            System.out.println("El año donde se realizó la mayor venta fue en el 2020");
        else
            System.out.println("El año donde se realizó la mayor venta fue en el 2019 y 2020");

    }
    static void ImprimeBarras(int[] ventas ,int year){
        System.out.println("Ventas del año " + year);
        System.out.println("-------------------");
        for (int i = 0; i < ventas.length ; i++){
            System.out.println(("#").repeat( ventas[i]) +"(" + (ventas[i]) + ")");
        }
    }
    static void GenerarVectores(int[] ventas19, int[] ventas20){
        for (int i = 0; i < ventas19.length; i++) {
            ventas19[i] = (int) Math.round(Math.random() * 30);
            ventas20[i] = (int) Math.round(Math.random() * 30);
        }
    }
    public static void main(String[] args) {
        int[] ventas19 = new int[12];
        int[] ventas20 = new int[12];
        GenerarVectores(ventas19, ventas20);
        ImprimeBarras(ventas19, 19);
        System.out.println();
        ImprimeBarras(ventas20, 20);
        MayorVenta(ventas19, ventas20);
    }
}