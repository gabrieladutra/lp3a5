package tarefa2_produtor_consumidor;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
/*
Referência para estudo: github/ingogbe
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProdutorConsumidor pc = new ProdutorConsumidor();

        Thread threadProdutor = new Thread(() -> {
            try {
                pc.produzir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadConsumidor = new Thread(() -> {
            try {
                pc.consumir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadProdutor.start();
        threadConsumidor.start();

        threadProdutor.join();
        threadConsumidor.join();
    }
}