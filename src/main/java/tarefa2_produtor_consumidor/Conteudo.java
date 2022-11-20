package tarefa2_produtor_consumidor;

public class Conteudo {
    private int valor;
    private Produtor produtor;

    public Conteudo(int valor, Produtor produtor){
        this.valor = valor;
        this.produtor = produtor;
    }

    public int getValor() {
        return valor;
    }

    public Produtor getProdutor() {
        return produtor;
    }
}
