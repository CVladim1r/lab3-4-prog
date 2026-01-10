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
}

