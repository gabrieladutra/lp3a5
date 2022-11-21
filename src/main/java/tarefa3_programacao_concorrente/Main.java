package tarefa3_programacao_concorrente;

import java.util.concurrent.ForkJoinPool;

/*
Baseado no  Link disponiblizado em Aula
 */

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] arrayDesordenado = {5, 2, 7, 6, 2, 1, 0, 3, 9, 4};
        System.out.println("arrayDesordenado (desordenado) = " + arrayToString(arrayDesordenado));
        arrayDesordenado = new int[]{5, 2, 7, 6, 2, 1, 0, 3, 9, 4};
        QuicksortForkJoinHoare quicksortTaskHoare = new QuicksortForkJoinHoare(arrayDesordenado);
        pool.invoke(quicksortTaskHoare);
        System.out.println("arrayDesordenado (ordenado com Quicksort de Hoare) = " + arrayToString(arrayDesordenado));

    }

    //Método auxiliar para imprimir os arrays
    private static String arrayToString(int[] array){
        StringBuilder aux = new StringBuilder("[" + array[0]);
        for(int i = 1; i < array.length; i++){
            aux.append(", ").append(array[i]);
        }
        return aux + "]";
    }
}
