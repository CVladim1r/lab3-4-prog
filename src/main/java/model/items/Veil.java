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

    @Override
    public String toString() {
        return super.toString() + " [открыт=" + opened + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Veil)) return false;
        Veil veil = (Veil) o;
        return opened == veil.opened;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (opened ? 1 : 0);
        return result;
    }
}

