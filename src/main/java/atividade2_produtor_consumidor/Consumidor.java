package atividade2_produtor_consumidor;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
public class Consumidor extends Thread {
    private String nomeConsumidor;
    private LinkedList<Conteudo> lista;
    private Semaphore semaforo;
    private Semaphore mutex;
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
        System.out.println("Consumidor \"" + getNomeConsumidor() + "\" read: " + conteudo.getValor() + " from " + conteudo.getProdutor().getNomeProdutor() + ". Consumptions left: " + getConsumosDecrementados());
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