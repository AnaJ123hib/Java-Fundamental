import java.util.ArrayList;

public class Main {
    static class Alumno {
        int course;
        int score;
    };

    static void Devuelve_mayor(Alumno[] VAlumnos){
        int puntajeMayor = 0;
        for (int i = 0; i < VAlumnos.length; i++) {
            if (VAlumnos[i].score > puntajeMayor) {
                puntajeMayor = VAlumnos[i].score;
            }
        }
        System.out.println("Puntaje mayor: " + puntajeMayor);
        for (int i = 0; i < VAlumnos.length; i++) {
            if (VAlumnos[i].score == puntajeMayor) {
                System.out.println("Alumno " + (1 + i) + " puntaje: " + VAlumnos[i].score);
            }
        }
    }
    static void Lista_EncimadelPromedio(Alumno[] VAlumnos){
        System.out.println("Alumnos con promedio mayor al promedio: ");
        int suma = 0;
        int average = 0;
        int i = 0;
        for(Alumno alumno : VAlumnos){
            suma += alumno.score;
        }
        average = suma / VAlumnos.length;
        System.out.println("Promedio: " + average);
        for(Alumno alumno: VAlumnos){
            if(alumno.score >= average){
                i++;
                System.out.println("Alumno " + i + ": " + "Curso: " + alumno.course + " " + "Puntaje: " +alumno.score);

            }
        }

    }
    static void GenerarMostrarDatos(Alumno[] VAlumnos){
        int course = 0;
        int  score = 0;
        for (int i = 0; i < VAlumnos.length; i++) {
            VAlumnos[i] = new Alumno();
            course = (int) (Math.random() * 3) + 1;
            score = (int) Math.round(Math.random() * 50) +1;

            VAlumnos[i].score = score;
            VAlumnos[i].course = course;
            System.out.print("Alumno " + (i + 1) + ": ");
            System.out.println("Tema: " + VAlumnos[i].course + ", Nota: " + VAlumnos[i].score);
        }
    }
    public static void main(String[] args) {
        Alumno[] VAlumnos = new Alumno[5];
        System.out.println("Datos de los alumnos");
        GenerarMostrarDatos(VAlumnos);
        Lista_EncimadelPromedio(VAlumnos);
        Devuelve_mayor(VAlumnos);
    }
}