package tarefa6_gilded_rose;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void atualizarQualidade() {
        for (Item item : items) {
            atualizarQualidade(item);
            atualizarVenda(item);
        }
    }

    private void atualizarQualidade(Item item) {
        if (!item.nome.equals("Aged Brie") && !item.nome.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.qualidade > 0) {
                if (!item.nome.equals("Sulfuras, Hand of Ragnaros")) {
                    item.qualidade = item.qualidade - 1;
                }
            }
        } else {
            if (item.qualidade < 50) {
                item.qualidade = item.qualidade + 1;

                if (item.nome.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.venda < 11) {
                        if (item.qualidade < 50) {
                            item.qualidade = item.qualidade + 1;
                        }
                    }

                    if (item.venda < 6) {
                        if (item.qualidade < 50) {
                            item.qualidade = item.qualidade + 1;
                        }
                    }
                }
            }
        }
    }

    public void atualizarVenda(Item item) {
        if (item.nome.equals("Sulfuras, Hand of Ragnaros")) {
        } else {
            item.venda = item.venda - 1;
        }

        verificarVencimento(item);
    }

    private void verificarVencimento(Item item) {
        if (item.venda < 0) verficarVencimento(item);
    }

    private void verficarVencimento(Item item) {
        if (item.nome.equals("Aged Brie")) {
            if (item.qualidade < 50) {
                item.qualidade = item.qualidade + 1;
            }
        } else {
            if (!item.nome.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.qualidade > 0) {
                    if (!item.nome.equals("Sulfuras, Hand of Ragnaros")) {
                        item.qualidade = item.qualidade - 1;
                    }
                }
            } else {
                item.qualidade = 0;
            }
        }
    }

    public void equals() {
    }
}