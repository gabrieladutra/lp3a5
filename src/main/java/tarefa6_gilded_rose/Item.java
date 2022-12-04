package tarefa6_gilded_rose;

public class Item {

    public String nome;

    public int venda;

    public int qualidade;

    public Item(String nome, int venda, int qualidade) {
        this.nome = nome;
        this.venda = venda;
        this.qualidade = qualidade;
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.venda + ", " + this.qualidade;
    }
}