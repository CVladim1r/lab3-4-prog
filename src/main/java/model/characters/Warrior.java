package model.characters;

import model.Character;
import model.items.Weapon;
import model.items.Idol;
import model.records.Drink;
import model.enums.Emotion;
import exceptions.RitualException;
import ritual.RitualContext;

public class Warrior extends Character {
    private Weapon weapon;
    private int drunkLevel;

    public Warrior(String name, Weapon weapon) {
        super(name);
        this.weapon = weapon;
        this.drunkLevel = 0;
    }

    public void chant() {
        System.out.println(getName() + " поёт.");
        try {
            spendStamina(5);
        } catch (RitualException e) {
            System.out.println(e.getMessage());
        }
    }

    public void scream() {
        System.out.println(getName() + " резко переходит на крики и поднимает оружие.");
        try {
            spendStamina(10);
        } catch (RitualException e) {
            System.out.println(e.getMessage());
        }
    }

    public void drink(Drink d) {
        drunkLevel += d.potency() / 10;
        System.out.println(getName() + " пьёт варево (крепость: " + d.potency() + "). Угар: " + drunkLevel);
        
        if (d.potency() > 7) {
            if (drunkLevel > 5) {
                changeEmotion(Emotion.FRENZY);
                System.out.println(getName() + " становится агрессивнее, хаотичнее, громче!");
            }
        } else {
            System.out.println(getName() + ": пойло слабое, не уходит в полный френзи. Действия будут спокойнее/медленнее.");
        }
    }

    public void carveIdol(Idol idol, int chips) throws RitualException {
        System.out.println(getName() + " кружит вокруг костра и рубит идол.");
        idol.carve(chips);
        try {
            spendStamina(15);
        } catch (RitualException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void act(RitualContext ctx) throws RitualException {
        if (drunkLevel < 3) {
            chant();
        } else {
            scream();
        }
    }

    public int getDrunkLevel() {
        return drunkLevel;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}

