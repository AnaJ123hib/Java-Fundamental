import java.util.Scanner;

public class Main {
    static double ClientAmout(int tipoPizza, String tipoPedido, int tiempo){
        if(tipoPedido.equals("M")){
            if(tiempo > 20)
                return 0;
        }
        if(tipoPedido.equals("D")){
            if(tiempo > 30)
                return 0;
        }

        double total = 0;
        switch (tipoPizza){
            case 1:
                total= 50.0;
                break;
            case 2:
                total= 60.0;
                break;
            default:
                total= 68.0;
        }


        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long cod = -1;
        int tipoPizza;
        String tipoPedido;
        int tiempo;
        double totalUser = 0;
        double userAmount ;
        int freeDelivery = 0;
        while (cod != 0) {
            try {
                System.out.print("Ingrese el código: ");
                cod = sc.nextLong();
                sc.nextLine();
                if (cod == 0) {
                    break;
                }
                while (true) {
                    try {
                        System.out.print("Tipo de pizza (1: grande; 2: familiar; 3: súper familiar): ");
                        tipoPizza = sc.nextInt();
                        sc.nextLine();
                        if (tipoPizza >= 1 && tipoPizza <= 3) {
                            break;
                        }
                    } catch (Exception e) {
                        sc.next();
                    }
                }

                while (true) {
                    try {
                        System.out.print("Tipo de pedido (D: delivery; M: mostrador): ");
                        tipoPedido = sc.nextLine().toUpperCase();
                        if (tipoPedido.equals("D") || tipoPedido.equals("M")) {
                            break;
                        }
                    } catch (Exception e) {
                        sc.next();
                    }
                }

                while (true) {
                    try {
                        System.out.print("Tiempo de entrega: ");
                        tiempo = sc.nextInt();
                        sc.nextLine();
                        if (tiempo > 0) {
                            break;
                        }
                    } catch (Exception e) {
                        sc.next();
                    }
                }
                userAmount= ClientAmout(tipoPizza, tipoPedido, tiempo);
                totalUser = totalUser + userAmount;
                System.out.println();
                if(userAmount == 0){
                    System.out.println("Importe a pagar GRATIS");
                    freeDelivery++;
                }
                else{
                    System.out.println("Importe a pagar: " + userAmount);
                }
            } catch (Exception e) {
                sc.next();
            }
        }
        sc.close();

        System.out.println("Importe total el último mes: " + totalUser);
        System.out.println("Cantidad de pedidos entregados gratis: " + freeDelivery);

    }
}
