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

    @Override
    public String toString() {
        return getName() + " [луч_солнца=" + sunHit + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SacredTree)) return false;
        if (!super.equals(o)) return false;
        SacredTree that = (SacredTree) o;
        return sunHit == that.sunHit;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sunHit ? 1 : 0);
        return result;
    }
}

