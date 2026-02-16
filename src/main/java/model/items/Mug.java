package model.items;

import model.Item;
import model.WorldObject;
import model.records.Drink;
import exceptions.RitualException;

public class Mug extends Item {
    private boolean broken;
    private Drink drink;

    public Mug(String name) {
        super(name, 10);
        this.broken = false;
        this.drink = null;
    }

    public void fill(Drink d) throws RitualException {
        if (broken) {
            throw new RitualException("Кружка разбита!");
        }
        this.drink = d;
        System.out.println(getName() + " наполняется пойлом");
    }

    public void breakOn(WorldObject target) {
        if (!broken) {
            this.broken = true;
            System.out.println(getName() + " разбивается о " + target.getName());
        }
    }

    public boolean isBroken() {
        return broken;
    }

    public Drink getDrink() {
        return drink;
    }

    @Override
    public String toString() {
        return super.toString() + " [разбита=" + broken + ", наполнена=" + (drink != null) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Mug)) return false;
        Mug mug = (Mug) o;
        return broken == mug.broken && 
               ((drink == null && mug.drink == null) || (drink != null && drink.equals(mug.drink)));
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (broken ? 1 : 0);
        result = 31 * result + (drink != null ? drink.hashCode() : 0);
        return result;
    }
}

