package tarefa2_produtor_consumidor;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/*
Referência para estudo: github/ingogbe
 */

public class Consumidor extends Thread {
    private final String nomeConsumidor;
    private final LinkedList<Conteudo> lista;
    private final Semaphore semaforo;
    private final Semaphore mutex;
    private int consumos;

    public Consumidor(String nomeConsumidor, LinkedList<Conteudo> lista, Semaphore sem, Semaphore mutex, int consumptions) {
        this.nomeConsumidor = nomeConsumidor;
        this.lista = lista;
        this.semaforo = sem;
        this.mutex = mutex;
        this.consumos = consumptions;
    }

    public void run() {
        try {
            while (getConsumos() > 0) {
                getSemaforo().acquire(1);

                getMutex().acquire();
                consume();
                getMutex().release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consume(){
        Conteudo conteudo = getLista().removeFirst();
        System.out.println("Consumidor \"" + getNomeConsumidor() + "\" lê: " + conteudo.getValor() + " de " + conteudo.getProdutor().getNomeProdutor() + ". Consumos restastes: " + getConsumosDecrementados());
    }

    public String getNomeConsumidor() {
        return this.nomeConsumidor;
    }

    public LinkedList<Conteudo> getLista() {
        return lista;
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public int getConsumos() {
        return consumos;
    }

    public int getConsumosDecrementados() {
        this.consumos--;
        return consumos;
    }



}