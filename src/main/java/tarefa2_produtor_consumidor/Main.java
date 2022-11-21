package tarefa2_produtor_consumidor;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
/*
Referência para estudo: github/ingogbe
 */

public class Main {

    public static void main(String[] args) {

        LinkedList<Conteudo> list = new LinkedList<>();
        Semaphore sem = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);

        new Produtor("Pedro", list, sem, mutex, 5).start();
        new Produtor("José", list, sem, mutex, 2).start();
        new Consumidor("Maria", list, sem, mutex, 1).start();
        new Consumidor("Elizabeth", list, sem, mutex, 3).start();
    }
}