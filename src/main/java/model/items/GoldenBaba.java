package model.items;

import exceptions.RitualException;

public class GoldenBaba extends Idol {
    private boolean hidden;

    public GoldenBaba(String name, int integrity) {
        super(name, integrity);
        this.hidden = true;
    }

    public void reveal() throws RitualException {
        if (!hidden) {
            throw new RitualException("Золотая Баба уже открыта!");
        }
        this.hidden = false;
        System.out.println("Полог открывается, и Золотая Баба на мгновение показывается.");
    }

    public void hide() {
        if (!hidden) {
            System.out.println("Золотую Бабу снова прячут в глубину дупла.");
            this.hidden = true;
        }
    }

    public boolean isHidden() {
        return hidden;
    }
}

