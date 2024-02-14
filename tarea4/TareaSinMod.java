package tarea4;

import java.util.Scanner;
//clase principal
public class TareaSinMod {
    /**
     * Genera un array de números primos hasta un máximo especificado.
     * @param max El límite hasta el cual buscar números primos.
     * @return Un array de enteros que contiene todos los números primos hasta max.
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
    /**
     * Convierte el array de booleanos a un array de números primos.
     * @param esPrimo Array de booleanos donde cada posición indica si el índice es primo.
     * @return Un array de enteros que contiene todos los índices marcados como primos.
     */
    public static int[] generarPrimos (int max) {
        int i,j;
        if (max >= 2) {
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            for (i=0; i<dim; i++)
                esPrimo[i] = true;
            // eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            // se hace criba
            for (i=2; i<Math.sqrt(dim)+1; i++) {
                if (esPrimo[i]) {
                    // se eliminan los múltiplos de i
                    for (j=2*i; j<dim; j+=i)
                        esPrimo[j] = false;
                }
            }
            // ¿Cuántos primos hay en este array?
            int cuenta = 0;
            for (i=0; i<dim; i++) {
                if (esPrimo[i])
                    cuenta++;
            }
            // se rellena el vector de números primos
            int[] primos = new int[cuenta];
            for (i=0, j=0; i<dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else { // max < 2
            return new int[0]; // vector vacío
        }
    }
}
