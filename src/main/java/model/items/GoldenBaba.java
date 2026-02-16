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

    @Override
    public String toString() {
        return super.toString() + " [спрятана=" + hidden + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof GoldenBaba)) return false;
        GoldenBaba that = (GoldenBaba) o;
        return hidden == that.hidden;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (hidden ? 1 : 0);
        return result;
    }
}

