package model.characters;

import model.Character;
import model.items.Fire;
import model.records.Ingredient;
import model.records.Prophecy;
import model.enums.IngredientType;
import interfaces.Diviner;
import exceptions.RitualException;
import ritual.RitualContext;

public class Shaman extends Character implements Diviner {
    public Shaman(String name) {
        super(name);
    }

    public void dance() {
        System.out.println(getName() + " входит в транс и начинает выполнять действия (вертится, кривляется, прыгает).");
        try {
            spendStamina(10);
        } catch (RitualException e) {
            System.out.println(e.getMessage());
        }
    }

    public void castSalt(Fire fire, Ingredient salt) throws RitualException {
        if (salt.type() != IngredientType.SALT) {
            throw new RitualException("Это не соль!");
        }
        System.out.println(getName() + " бросает горсть соли в огонь.");
        fire.addSalt(salt);
    }

    @Override
    public Prophecy predict(RitualContext ctx) throws RitualException {
        System.out.println(getName() + " начинает гадать. Рассыпает гадательные штуки/знаки и читает результат.");
        
        // Рандомное предсказание
        boolean godsPleased = ctx.chance(0.5);
        String text;
        int certainty;
        
        if (godsPleased) {
            text = "Боги довольны";
            certainty = 80;
            System.out.println(getName() + " объявляет: \"" + text + "\" - жертвенная часть будет короче.");
        } else {
            text = "Нужна жертва";
            certainty = 90;
            System.out.println(getName() + " объявляет: \"" + text + "\" - все резко ускоряются к кульминации.");
        }
        
        return new Prophecy(text, certainty);
    }

    @Override
    public void act(RitualContext ctx) throws RitualException {
        dance();
    }
}

