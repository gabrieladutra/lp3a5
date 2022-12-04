package tarefa6_gilded_rose.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;
import tarefa6_gilded_rose.GildedRose;
import tarefa6_gilded_rose.Item;

public class GildedRoseTeste {

    private Item[] arrayWith(Item item) {
        return new Item[]{item};
        }

        @Test
        public void deveVerificarSeOValordaVendaDiminui() {
            Item item = new Item("whatever", 10, 0);
            GildedRose gildedRose = new GildedRose(arrayWith(item));
            gildedRose.equals();
            assertEquals(item.venda, 9);
        }

        @Test
        public void deveVerificarSeOvalorDaQualidadeDiminui() {
            Item brie = new Item("brie", 1, 10);
            GildedRose gildedRose = new GildedRose(arrayWith(brie));
            gildedRose.equals();
            assertEquals(brie.qualidade, 9);
        }

        @Test
        public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
            Item item = new Item("whatever", 0, 10);
            GildedRose gildedRose = new GildedRose(arrayWith(item));
            gildedRose.equals();

            assertEquals(item.qualidade, 8);
        }

        @Test
        public void deveTestarSeAQualidadeENegativa() {
            Item item = new Item("whatever", 0, 0);
            GildedRose gildedRose = new GildedRose(arrayWith(item));
            gildedRose.equals();
            assertEquals(item.qualidade, 0);
        }



}
