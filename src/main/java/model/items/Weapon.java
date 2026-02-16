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

    @Override
    public String toString() {
        return super.toString() + " [тип=" + type + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Weapon)) return false;
        Weapon weapon = (Weapon) o;
        return type == weapon.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}

