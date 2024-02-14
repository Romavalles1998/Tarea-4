package tarea4;
import java.util.Scanner;
//página dónde está mi código: https://github.com/Romavalles1998/Tarea-4.git
public class TareaModificada {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int limite = scanner.nextInt();
        int[] primos = generarPrimos(limite);
        System.out.println("\nNúmeros primos hasta " + limite + ":");
        imprimirPrimos(primos);
    }

    // Genera números primos hasta un max especificado
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0]; // Retorna un vector vacío si el max es menor que 2
        }
        boolean[] esPrimo = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            esPrimo[i] = true;
        }
        for (int factor = 2; factor*factor <= max; factor++) {
            if (esPrimo[factor]) {
                for (int j = factor * factor; j <= max; j += factor) {
                    esPrimo[j] = false;
                }
            }
        }
        return filtrarPrimos(esPrimo);
    }

    // imprime los números primos
    private static void imprimirPrimos(int[] primos) {
        for (int primo : primos) {
            System.out.print(primo + "\t");
        }
        System.out.println();
    }

    // filtra y retorna un array de números primos desde un array de booleanos
    private static int[] filtrarPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) {
                cuenta++;
            }
        }
        int[] primos = new int[cuenta];
        for (int i = 2, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }
}
