package tarefa2_produtor_consumidor;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;


public class Main {

    public static void main(String[] args) {

        LinkedList<Conteudo> list = new LinkedList<Conteudo>();
        Semaphore sem = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);

        new Produtor("Gabriela", list, sem, mutex, 5).start();
        new Produtor("Eric", list, sem, mutex, 2).start();
        new Produtor("Nicholas", list, sem, mutex, 1).start();
        new Produtor("Michele", list, sem, mutex, 3).start();
    }
}