import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Tienda{
        int code;
        int aguaFee;
        int luzFee;
        int minutes;
    }

    static void AverageFee(Tienda[] tiendaVector){
        double aguaFee = 0;
        double luzFee = 0;
        double minuteFee = 0;

        for (Tienda tienda : tiendaVector) {
            aguaFee = tienda.aguaFee + aguaFee;
            luzFee = tienda.luzFee + luzFee;
            minuteFee = tienda.minutes + minuteFee;
        }

        System.out.println("Consumo promedio de agua: " + (aguaFee/tiendaVector.length));
        System.out.println("Consumo promedio de luz: " + (luzFee/tiendaVector.length));
        System.out.println("Consumo promedio de llamadas: " + (minuteFee/tiendaVector.length));

    }
    static void MaxFee(List<Double>totalVector, Tienda[] tiendaVector){
        double maxFeed = Collections.max(totalVector);
        System.out.println("Tienda(s) con mayor gastos: ");

        for(int i = 0; i< totalVector.size(); i ++){
            if(totalVector.get(i) == maxFeed){
                System.out.println("Tienda " + tiendaVector[i].code + ": " + totalVector.get(i));
            }
        }
        System.out.println("\n");
    }
    static List<Double> TotalFee(Tienda[] tiendaVector, List<Double>totalVector){
        for(Tienda tienda: tiendaVector){
            double totalTienda = (tienda.aguaFee * 3.35) + (tienda.luzFee * 0.45) + (tienda.minutes * 0.15);
            totalVector.add(totalTienda);
        }
        for (int i= 0; i < totalVector.size(); i++){
            System.out.println("Tienda " + tiendaVector[i].code + " gastos: " + Math.round(totalVector.get(i)));
        }
        System.out.println("\n");

        return totalVector;
    }
    static void LessAmountMinuts(Tienda[] tiendaVector){
        int lessFee = Integer.MAX_VALUE;;
        System.out.println("\nTienda(s) codigo con menos consumo de minutos de llamadas");
        for(Tienda tienda: tiendaVector){
            if(tienda.minutes < lessFee) {lessFee = tienda.minutes;}
        }
        for(Tienda tienda: tiendaVector){
            if(tienda.minutes == lessFee){
                System.out.println(tienda.code);
            }
        }
        System.out.println("\n");

    }
    static void GenerarVector(Tienda[] tiendaVector){
        int code = 1000;
        int aguaFee;
        int luzFee;
        int minutes;
        System.out.println("Codigo\t " + "Con. agua\t " + "Con. luz\t " + "Con. minutos");
        System.out.println("---------------------------------------------");
        for(int i = 0; i < tiendaVector.length ; i++){
            tiendaVector[i] = new Tienda();
            aguaFee = ((int) Math.round(Math.random() * 195) + 5);
            luzFee = ((int) Math.round(Math.random() * 290) + 10);
            minutes = ((int) Math.round(Math.random() * 470) + 30);

            tiendaVector[i].code = code;
            tiendaVector[i].aguaFee = aguaFee;
            tiendaVector[i].luzFee = luzFee;
            tiendaVector[i].minutes = minutes;
            System.out.println(tiendaVector[i].code + "   |\t"+ tiendaVector[i].aguaFee + "\t\t|\t" + tiendaVector[i].luzFee + "\t\t| \t" + tiendaVector[i].minutes);
            code++;
        }

    }
    public static void main(String[] args) {
        Tienda[] tiendaVector = new Tienda[25];
        List<Double> totalVector = new ArrayList<Double>();

        System.out.println("Datos generados \n");
        GenerarVector(tiendaVector);
        LessAmountMinuts(tiendaVector);
        totalVector = TotalFee(tiendaVector, totalVector);
        MaxFee(totalVector, tiendaVector);
        AverageFee(tiendaVector);
    }
}