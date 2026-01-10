package model.items;

import model.Item;

public class Veil extends Item {
    private boolean opened;

    public Veil(String name) {
        super(name, 100);
        this.opened = false;
    }

    public void open() {
        if (!opened) {
            this.opened = true;
            System.out.println("Полог открывается.");
        }
    }

    public void close() {
        if (opened) {
            this.opened = false;
            System.out.println("Полог закрывается.");
        }
    }

    public boolean isOpened() {
        return opened;
    }
}

