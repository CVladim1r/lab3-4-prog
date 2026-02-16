package model.items;

import model.WorldObject;
import model.records.Ingredient;
import model.records.Drink;
import exceptions.RitualException;

import java.util.ArrayList;
import java.util.List;

public class Cauldron extends WorldObject {
    private int temperature;
    private List<Ingredient> contents;

    public Cauldron(String name) {
        super(name);
        this.temperature = 20;
        this.contents = new ArrayList<>();
    }

    public void boil() {
        this.temperature += 50;
        System.out.println(getName() + " начинает активно булькать. Температура: " + temperature);
    }

    public void add(Ingredient ing) {
        contents.add(ing);
        System.out.println("В котёл летит: " + ing.type() + " (количество: " + ing.amount() + ")");
    }

    public Drink scoop() throws RitualException {
        if (contents.isEmpty()) {
            throw new RitualException("Котёл пуст!");
        }
        // кпепость пойла зависит от случайности (рандом)
        int potency = (int) (Math.random() * 100);
        String name = "Варево";
        System.out.println("Воины черпают варево из котла. Крепость: " + potency);
        return new Drink(name, potency);
    }

    public List<Ingredient> getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return getName() + " [температура=" + temperature + ", ингредиентов=" + contents.size() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cauldron)) return false;
        if (!super.equals(o)) return false;
        Cauldron cauldron = (Cauldron) o;
        return temperature == cauldron.temperature && contents.equals(cauldron.contents);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + temperature;
        result = 31 * result + contents.hashCode();
        return result;
    }
}

