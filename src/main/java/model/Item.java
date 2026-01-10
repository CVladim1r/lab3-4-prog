package model;

public abstract class Item extends WorldObject {
    protected int durability;

    public Item(String name, int durability) {
        super(name);
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void reduceDurability(int amount) {
        durability = Math.max(0, durability - amount);
    }
}

