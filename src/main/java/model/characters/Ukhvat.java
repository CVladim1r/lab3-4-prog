package model.characters;

import model.Character;
import model.WorldObject;
import model.enums.Emotion;
import exceptions.PanicException;
import exceptions.RitualException;
import ritual.RitualContext;

public class Ukhvat extends Character {
    private int courage;
    private int sneezeCount;

    public Ukhvat(String name) {
        super(name);
        this.courage = 50; // смелость на половине +-
        this.sneezeCount = 0;
    }

    public void crossSelf() {
        System.out.println(getName() + " перекрещивается и пытается держать себя в руках.");
        courage += 5;
    }

    public void sneeze() {
        sneezeCount++;
        System.out.println(getName() + " чихает (реакция на чад). Чих #" + sneezeCount);
    }

    public void approach(WorldObject target) throws PanicException {
        if (courage < 30) {
            throw new PanicException(getName() + " паникует! Смелость слишком низкая (" + courage + "). Зажмуривается, отворачивается и не может смотреть.");
        }
        System.out.println(getName() + " пытается приблизиться к " + target.getName() + ". Смелость: " + courage);
    }

    @Override
    public void act(RitualContext ctx) throws RitualException {
        System.out.println(getName() + " наблюдает за ритуалом.");
    }

    public int getCourage() {
        return courage;
    }

    public void setCourage(int courage) {
        this.courage = courage;
        if (courage < 20) {
            changeEmotion(Emotion.FEAR);
        }
    }
}

