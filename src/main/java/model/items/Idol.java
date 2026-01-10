package model.items;

import model.Item;
import exceptions.RitualException;

public class Idol extends Item {
    private int integrity;

    public Idol(String name, int integrity) {
        super(name, 100);
        this.integrity = integrity;
    }

    public void carve(int chips) throws RitualException {
        if (integrity <= 0) {
            throw new RitualException("Идол уже разрушен!");
        }
        integrity = Math.max(0, integrity - chips);
        System.out.println("Воины рубят идол, срезая щепки. Целостность идола: " + integrity);
        if (integrity <= 0) {
            System.out.println("Идол превратился в обрубок.");
        }
    }

    public int getIntegrity() {
        return integrity;
    }
}

