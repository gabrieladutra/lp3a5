package tarefa2_produtor_consumidor;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
/*
Referência para estudo: github/ingogbe
 */

public class Produtor extends Thread {
    private final String nomeProdutor;
    private final LinkedList<Conteudo> lista;
    private final Semaphore semaforo;
    private final Semaphore mutex;
    private int productions;

    public Produtor(String nomeProdutor, LinkedList<Conteudo> lista, Semaphore semaforo, Semaphore mutex, int producao){
        this.nomeProdutor = nomeProdutor;
        this.lista = lista;
        this.semaforo = semaforo;
        this.mutex = mutex;
        this.productions = producao;
    }

    @SuppressWarnings("BusyWait")
    public void run() {
        try {
            while (getProductions() > 0) {
                getMutex().acquire();
                produce();
                getMutex().release();

                getSemaforo().release(1);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void produce(){
        Conteudo conteudo = new Conteudo(getDecrementedProductions(), this);
        getLista().add(conteudo);
        System.out.println("Produtor \"" + getNomeProdutor() + "\" escreve: " + conteudo.getValor());
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

    public String getNomeProdutor() {
        return nomeProdutor;
    }

    public int getProductions() {
        return productions;
    }

    public int getDecrementedProductions() {
        this.productions--;
        return productions;
    }



}