package model.items;

import model.Item;
import model.enums.WeaponType;

public class Weapon extends Item {
    private WeaponType type;

    public Weapon(String name, WeaponType type, int durability) {
        super(name, durability);
        this.type = type;
    }

    public WeaponType getType() {
        return type;
    }
}

