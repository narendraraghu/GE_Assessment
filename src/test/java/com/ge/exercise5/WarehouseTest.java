package com.ge.exercise5;

import org.junit.Before;
import org.junit.Test;

import static com.ge.exercise5.ItemType.*;
import static org.junit.Assert.assertEquals;

public class WarehouseTest {

    private Warehouse warehouse;

    @Before
    public void setUp() {
        warehouse = new Warehouse();
    }

    /**
     * normal item tests
     */

    @Test
    public void normalItemBeforeSellDateTest() {
        Item item = new Item(NORMAL, 10, 15);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(9, item.getValue());
        assertEquals(14, item.getSellBy());
    }

    @Test
    public void normalItemOnSellDateTest() {
        Item item = new Item(NORMAL, 10, 0);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(8, item.getValue());
        assertEquals(-1, item.getSellBy());
    }

    @Test
    public void normalItemAfterSellDateTest() {
        Item item = new Item(NORMAL, 10, -1);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(8, item.getValue());
        assertEquals(-2, item.getSellBy());
    }

    @Test
    public void normalItemNearZeroValue() {
        Item item = new Item(NORMAL, 1, 10);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(0, item.getValue());
        assertEquals(9, item.getSellBy());
    }

    @Test
    public void normalItemZeroValue() {
        Item item = new Item(NORMAL, 0, 10);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(0, item.getValue());
        assertEquals(9, item.getSellBy());
    }

    /**
     * ageable item tests
     */

    @Test
    public void ageableItemBeforeSellDateTest() {
        Item item = new Item(AGEABLE, 10, 15);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(11, item.getValue());
        assertEquals(14, item.getSellBy());
    }

    @Test
    public void ageableItemBeforeSellDateMaxValueTest() {
        Item item = new Item(AGEABLE, 50, 1);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(0, item.getSellBy());
    }

    @Test
    public void ageableItemOnSellDateTest() {
        Item item = new Item(AGEABLE, 10, 0);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(12, item.getValue());
        assertEquals(-1, item.getSellBy());
    }

    @Test
    public void ageableItemOnSellDateNearMaxValueTest() {
        Item item = new Item(AGEABLE, 49, 0);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(-1, item.getSellBy());
    }

    @Test
    public void ageableItemOnSellDateWithMaxValueTest() {
        Item item = new Item(AGEABLE, 50, 0);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(-1, item.getSellBy());
    }

    @Test
    public void ageableItemAfterSellDateTest() {
        Item item = new Item(AGEABLE, 10, -1);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(12, item.getValue());
        assertEquals(-2, item.getSellBy());
    }

    @Test
    public void ageableItemAfterSellDateWithMaxValueTest() {
        Item item = new Item(AGEABLE, 50, -1);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(-2, item.getSellBy());
    }

    /**
     * precious item tests
     */

    @Test
    public void preciousItemBeforeSellDateTest() {
        Item item = new Item(PRECIOUS, 100, 15);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(100, item.getValue());
        assertEquals(15, item.getSellBy());
    }

    @Test
    public void preciousItemOnSellDateTest() {
        Item item = new Item(PRECIOUS, 100, 0);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(100, item.getValue());
        assertEquals(0, item.getSellBy());
    }

    @Test
    public void preciousItemAfterSellDateTest() {
        Item item = new Item(PRECIOUS, 100, -1);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(100, item.getValue());
        assertEquals(-1, item.getSellBy());
    }

    /**
     * rare item
     */

    @Test
    public void rareItemWellBeforeSellDateTest() {
        Item item = new Item(RARE, 10, 20);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(11, item.getValue());
        assertEquals(19, item.getSellBy());
    }

    @Test
    public void rareItemWellBeforeSellDateAtMaxValueTest() {
        Item item = new Item(RARE, 50, 20);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(19, item.getSellBy());
    }

    @Test
    public void rareItemWithin2weeksUpperBoundTest() {
        Item item = new Item(RARE, 10, 14);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(12, item.getValue());
        assertEquals(13, item.getSellBy());
    }

    @Test
    public void rareItemWithin2weeksUpperBoundAtMaxValueTest() {
        Item item = new Item(RARE, 49, 14);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(13, item.getSellBy());
    }

    @Test
    public void rareItemWithin2weeksLowerBoundTest() {
        Item item = new Item(RARE, 10, 8);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(12, item.getValue());
        assertEquals(7, item.getSellBy());
    }

    @Test
    public void rareItemWithin2weeksLowerBoundAtMaxValueTest() {
        Item item = new Item(RARE, 49, 8);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(7, item.getSellBy());
    }

    @Test
    public void rareItemWithin1weeksUpperBoundTest() {
        Item item = new Item(RARE, 10, 7);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(13, item.getValue());
        assertEquals(6, item.getSellBy());
    }

    @Test
    public void rareItemWithin1weeksUpperAtMaxValueBoundTest() {
        Item item = new Item(RARE, 49, 7);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(6, item.getSellBy());
    }

    @Test
    public void rareItemWithin1weeksLowerBoundTest() {
        Item item = new Item(RARE, 10, 1);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(13, item.getValue());
        assertEquals(0, item.getSellBy());
    }

    @Test
    public void rareItemWithin1weeksLowerBoundAtMaxValueTest() {
        Item item = new Item(RARE, 49, 1);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(50, item.getValue());
        assertEquals(0, item.getSellBy());
    }


    @Test
    public void rareItemOnSellDate() {
        Item item = new Item(RARE, 10, 0);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(0, item.getValue());
        assertEquals(-1, item.getSellBy());
    }

    @Test
    public void rareItemOnAfterSellDate() {
        Item item = new Item(RARE, 10, -1);
        warehouse.addItem(item);
        warehouse.updateItems();
        assertEquals(0, item.getValue());
        assertEquals(-2, item.getSellBy());
    }
}