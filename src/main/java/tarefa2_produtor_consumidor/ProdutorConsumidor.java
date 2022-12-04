package tarefa2_produtor_consumidor;

import java.util.LinkedList;

/*
Referência para estudo: YouTube
 */

public class ProdutorConsumidor {
        LinkedList<Integer> lista = new LinkedList<>();
        int tamanho = 2;
        public void produzir() throws InterruptedException {
            int valor = 0;
            do {
                synchronized (this) {
                    while (lista.size() == tamanho)
                        wait();

                    System.out.println("Produtor produz --> " + valor);

                    lista.add(valor++);

                    notify();
                    Thread.sleep(1000);
                }
            } while (true);
        }

        public void consumir() throws InterruptedException {
            do {
                synchronized (this) {
                    while (lista.size() == 0)
                        wait();

                    int valor = lista.removeFirst();

                    System.out.println("Consumidor consome --> " + valor);

                    notify();

                    // Usando o sleep()
                    Thread.sleep(1000);
                }
            } while (true);
        }

}
