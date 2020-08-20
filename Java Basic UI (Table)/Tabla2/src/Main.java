import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IllegalArgumentException {
        try {
            bienvenida();
        } catch (IOException e) {
            System.out.println("Error en la entrada");
        }
    }

    private static void bienvenida() throws IOException{
        System.out.println("¡Bienvenido!");
        System.out.println("Ingrese las notas de sus 3 exámenes");
        calcularPromedio();
    }

    public static void calcularPromedio() throws IllegalArgumentException, IOException {
        try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Ingrese la nota de su primer examen:");
                int primero = Integer.parseInt(br.readLine());
                if ((primero < 0 || primero > 100)) {
                    throw new IllegalArgumentException();
                }
                System.out.println("Ingrese la nota de su segundo examen:");
                int segundo = Integer.parseInt(br.readLine());
                if ((segundo < 0 || segundo > 100)) {
                    throw new IllegalArgumentException();
                }
                System.out.println("Ingrese la nota de su tercer examen:");
                int tercero = Integer.parseInt(br.readLine());
                if ((tercero < 0 || tercero > 100)) {
                    throw new IllegalArgumentException();
                }
                int suma = primero + segundo + tercero;
                System.out.println("Su promedio es: " + suma / 3);
                System.out.println("Su condición es: " + condicion(suma / 3));
                bienvenida();

        } catch (IllegalArgumentException ex){
            System.out.println("Error en la entrada");
            bienvenida();
        } finally {
            System.out.println("Adiós, gracias por participar");
        }
    }

    public static String condicion(float nota){
        if (nota >= 67.5){
            return "Aprobado";
        }
        else{
            return "No aprobado";
        }
    }
}

