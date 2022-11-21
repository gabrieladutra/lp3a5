package tarefa2_produtor_consumidor;

/*
Referência para estudo: github/ingogbe
 */

public class Conteudo {
    private final int valor;
    private final Produtor produtor;

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
