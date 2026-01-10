package model.characters;

import model.Character;
import model.enums.RitualPhase;
import exceptions.RitualException;
import ritual.RitualSite;
import ritual.RitualContext;

public class VoglePrince extends Character {
    public VoglePrince(String name) {
        super(name);
    }

    public void signalStartSacrifice(RitualSite site) {
        System.out.println(getName() + " поднимает знак (тамгу) -> толпа ревёт.");

        if (site.getPhase() != RitualPhase.FINISH) {
            site.advancePhase();
        }
    }

    @Override
    public void act(RitualContext ctx) throws RitualException {
        System.out.println(getName() + " наблюдает за ритуалом.");
    }
}

