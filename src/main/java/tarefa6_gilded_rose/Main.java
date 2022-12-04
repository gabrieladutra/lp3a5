package tarefa6_gilded_rose;

public class Main {
    public static void main(String[] args) {
        System.out.println("Minha Nossa!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = args.length > 0 ? Integer.parseInt(args[0]) + 1 : 2;

        int i = 0;
        while (i < days) {
            System.out.println("-------- dia" + i + " --------");
            System.out.println("nome, venda, qualidade");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.atualizarQualidade();
            i++;
        }
    }
}
