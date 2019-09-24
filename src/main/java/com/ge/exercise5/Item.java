package com.ge.exercise5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Item {

    private static final Logger logger = LogManager.getLogger(Item.class);

    private ItemType type;
    private int value;
    private int sellBy;

    Item(ItemType itemType, int value, int sellBy) {
        this.type = itemType;
        this.value = value;
        this.sellBy = sellBy;
    }

     ItemType getType() {
        return type;
    }

     int getValue() {
        return value;
    }

     void setValue(int value) {
        this.value = value;
    }

    int getSellBy() {
        return sellBy;
    }

    void setSellBy(int sellBy) {
        this.sellBy = sellBy;
    }
}
