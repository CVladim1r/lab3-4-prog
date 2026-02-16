package model;

import model.enums.Emotion;
import exceptions.RitualException;
import ritual.RitualContext;

public abstract class Character extends WorldObject {
    protected Emotion emotion;
    protected int stamina;

    public Character(String name) {
        super(name);
        this.emotion = Emotion.CALM;
        this.stamina = 100;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void changeEmotion(Emotion e) {
        this.emotion = e;
        System.out.println(this.getName() + " меняет эмоцию на: " + e);
    }

    public void spendStamina(int cost) throws RitualException {
        if (stamina < cost) {
            throw new RitualException("Недостаточно выносливости у " + getName());
        }
        stamina -= cost;
        if (stamina <= 0) {
            changeEmotion(Emotion.EXHAUSTED);
        }
    }

    public int getStamina() {
        return stamina;
    }

    public abstract void act(RitualContext ctx) throws RitualException;

    @Override
    public String toString() {
        return super.toString() + " [эмоция=" + emotion + ", выносливость=" + stamina + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Character character = (Character) o;
        return stamina == character.stamina && emotion == character.emotion;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + emotion.hashCode();
        result = 31 * result + stamina;
        return result;
    }
}

