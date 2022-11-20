package tarefa3_programacao_concorrente;
import java.util.concurrent.RecursiveAction;

public class QuicksortForkJoinHoare extends RecursiveAction {
    private int[] arrayDesordenado;
    private int inicio;
    private int fim;

    public QuicksortForkJoinHoare(int[] arrayDesordenado, int inicio, int fim){
        this.arrayDesordenado = arrayDesordenado;
        this.inicio = inicio;
        this.fim = fim;
    }
    public QuicksortForkJoinHoare(int[] arrayDesordenado){
        this(arrayDesordenado, 0, arrayDesordenado.length - 1);
    }
    @Override
    protected void compute() {
        if(inicio < fim){
            int q = partiticao(arrayDesordenado, inicio, fim);
            invokeAll(new QuicksortForkJoinHoare(arrayDesordenado, inicio, q - 1),
                    new QuicksortForkJoinHoare(arrayDesordenado, q + 1, fim));
        }
    }
    private static int partiticao(int[] array, int inicio, int fim){
        int pivo = array[inicio];
        int i = inicio + 1;
        int j = fim;
        while(i <= j){
            while(i <= j && array[i] <= pivo) i = i + 1;
            while(i <= j && array[j] > pivo) j = j - 1;
            if(i < j) troca(array, i, j);
        }
        troca(array, inicio, j);
        return j;
    }
    private static void troca(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}