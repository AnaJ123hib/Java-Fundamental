import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static void Listado_ordenado(Object[][] listClientes, int n){
        Arrays.sort(listClientes, Comparator.comparingInt(o -> (int) o[0]));
        System.out.println("Listado ordenado: ");
        System.out.println("Edad \tTiempo\t Grado");
        for(int i = 0; i < n ; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(listClientes[i][j] + "\t    " );
            }
            System.out.print("\n");
        }
    }
    static  int Promedio_edad(Object[][] listClients , int n){
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n ; i++){
            for(int j = 0; j < 3; j++){
                if( listClients[i][2] == "A" ){
                    count+=1;
                    sum = sum + ((int) listClients[i][0]);
                }
            }
        }
        if(count == 0) return 0;
        return ((int) (sum / count));
    }
    static int Porcentaje_4y8_malo(Object[][] listClients , int n){
        int count = 0;

        for (int i = 0; i < n ; i++){
            for(int j = 0; j < 3; j++){
                if( listClients[i][1] == "C" && listClients[i][2] == "E"){
                    count+=1;
                }
            }
        }
        return ((int) ( count * 100 / n));
    }
    static void Generar_y_Mostrar(Object[][] listClients , int n){
        String[] letterArray = {"A", "B" , "C", "D", "E"};
        int timeIndex;
        int gradeIndex;
        int age = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j <3; j++){
                age = ((int) Math.round(Math.random() * 42) + 18);
                if(j == 1){
                    timeIndex = ((int) Math.round(Math.random() * 3) );
                    listClients[i][j] = letterArray[timeIndex];
                    continue;
                }
                if(j == 2){
                    gradeIndex = ((int) Math.round(Math.random() * 4));
                    listClients[i][j] = letterArray[gradeIndex];
                    continue;
                }
                listClients[i][j] = age;
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println("Cliente " + (i + 1));
            System.out.println("¿Desde cuándo es cliente?" + listClients[i][1]);
            System.out.println("¿Cuál es su grado de satisfacción con el servicio brindado?" + listClients[i][2]);
            System.out.println("Edad: " + listClients[i][0]);
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int clientsNumber = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Ingrese Número de clientes: ");
            clientsNumber = scanner.nextInt();
            if(clientsNumber > 0 && clientsNumber <= 100){
                Object[][] listClients = new Object[clientsNumber][3];
                System.out.println("Entonces los valores generados aleatoriamente fueron: ");
                Generar_y_Mostrar(listClients, clientsNumber);
                System.out.println("Resultados: ");
                System.out.println("Porcentaje de clientes entre 4 y 8 años y grado de satisfacción malo: " + Porcentaje_4y8_malo(listClients, clientsNumber) + "%");
                System.out.println("Promedio de edad de clientes que consideran excelente el servicio: " + Promedio_edad(listClients, clientsNumber));
                Listado_ordenado(listClients, clientsNumber);
                break;
            }
        }

    }
}