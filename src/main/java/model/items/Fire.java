package model.items;

import model.WorldObject;
import model.records.Ingredient;
import model.enums.IngredientType;

public class Fire extends WorldObject {
    private int intensity;
    private int smoke;

    public Fire(String name) {
        super(name);
        this.intensity = 10;
        this.smoke = 5;
    }

    public void ignite() {
        this.intensity += 10;
        System.out.println(getName() + " разгорается сильнее. Интенсивность: " + intensity);
    }

    public void addSalt(Ingredient salt) {
        if (salt.type() == IngredientType.SALT) {
            System.out.println("Шаман бросает горсть соли в огонь. Огонь даёт вспышку искр!");
            this.intensity += 20;
            increaseSmoke(salt.amount() * 5);
        }
    }

    public void increaseSmoke(int delta) {
        this.smoke += delta;
        System.out.println("Дым усиливается. Уровень дыма: " + smoke);
    }

    public int getSmoke() {
        return smoke;
    }

    public int getIntensity() {
        return intensity;
    }
}

