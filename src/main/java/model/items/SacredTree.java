package model.items;

import model.WorldObject;
import ritual.RitualSite;

public class SacredTree extends WorldObject {
    private boolean sunHit;

    public SacredTree(String name) {
        super(name);
        this.sunHit = false;
    }

    public void hitBySun(RitualSite site) {
        if (!sunHit) {
            this.sunHit = true;
            System.out.println("Солнце садится: луч попадает в священную ель -> триггер ритуальной фазы.");
            site.advancePhase();
        }
    }

    public boolean isSunHit() {
        return sunHit;
    }
}

