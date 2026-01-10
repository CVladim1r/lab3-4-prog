package ritual;

import java.util.Random;

public class RitualContext {
    private RitualSite site;
    private Random rng;

    public RitualContext(RitualSite site) {
        this.site = site;
        this.rng = new Random();
    }

    public RitualSite site() {
        return site;
    }

    public boolean chance(double p) {
        return rng.nextDouble() < p;
    }

    public int nextInt(int bound) {
        return rng.nextInt(bound);
    }

    public Random getRng() {
        return rng;
    }
}

