package model.characters;

import model.Character;
import model.enums.Emotion;
import exceptions.RitualException;
import ritual.RitualContext;

public class Prisoner extends Character {
    private boolean bound;
    private boolean gagged;
    private int health;

    public Prisoner(String name) {
        super(name);
        this.bound = true;
        this.gagged = true;
        this.health = 100;
        this.emotion = Emotion.EXHAUSTED;
    }

    public void awaken() {
        System.out.println(getName() + " очухивается от дыма и понимает, что происходит.");
        changeEmotion(Emotion.FEAR);
    }

    public void takeDamage(int dmg) {
        health = Math.max(0, health - dmg);
        System.out.println(getName() + " получает урон: " + dmg + ". Здоровье: " + health);
        if (health <= 0) {
            changeEmotion(Emotion.EXHAUSTED);
        }
    }

    public void awakenFromSmoke(int smokeLevel) {
        if (smokeLevel > 50) {
            System.out.println(getName() + " едва поднимает голову. Дым был слишком сильный, просыпается хуже/позже.");
        } else {
            awaken();
        }
    }

    @Override
    public void act(RitualContext ctx) throws RitualException {
        if (health <= 0) {
            System.out.println(getName() + " лежит без движения.");
        } else if (bound) {
            System.out.println(getName() + " пытается освободиться.");
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean isBound() {
        return bound;
    }

    public boolean isGagged() {
        return gagged;
    }

    @Override
    public String toString() {
        return super.toString() + " [здоровье=" + health + ", связан=" + bound + ", заткнут=" + gagged + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Prisoner)) return false;
        Prisoner prisoner = (Prisoner) o;
        return bound == prisoner.bound && gagged == prisoner.gagged && health == prisoner.health;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bound ? 1 : 0);
        result = 31 * result + (gagged ? 1 : 0);
        result = 31 * result + health;
        return result;
    }
}

