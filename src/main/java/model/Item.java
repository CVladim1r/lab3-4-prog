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

    @Override
    public String toString() {
        return super.toString() + " [прочность=" + durability + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return durability == item.durability;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + durability;
        return result;
    }
}

