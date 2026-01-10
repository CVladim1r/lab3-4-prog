package model.characters;

import model.Character;
import model.items.Weapon;
import interfaces.Executioner;
import exceptions.RitualException;
import ritual.RitualContext;

public class PrinceTeen extends Character implements Executioner {
    private Weapon knife;

    public PrinceTeen(String name, Weapon knife) {
        super(name);
        this.knife = knife;
    }

    @Override
    public void execute(Prisoner p, RitualContext ctx) throws RitualException {
        System.out.println(getName() + " бросается к пленнику " + p.getName() + " с ножом.");
        
        int strikeType = ctx.nextInt(3);
        
        if (strikeType == 0) {
            System.out.println("Успешный удар! Нож попадает точно.");
            p.takeDamage(100);
            try {
                spendStamina(20);
            } catch (RitualException e) {
                System.out.println(e.getMessage());
            }
        } else if (strikeType == 1) {
            int damage = 35 + ctx.nextInt(15);
            System.out.println("Частичный удар! Нож наносит " + damage + " урона.");
            p.takeDamage(damage);
            try {
                spendStamina(15);
            } catch (RitualException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Промах! " + getName() + " промахивается.");
            try {
                spendStamina(5);
            } catch (RitualException e) {
                System.out.println(e.getMessage());
            }
        }
        
        if (p.getHealth() <= 0) {
            System.out.println("Пленник " + p.getName() + " погибает.");
        }
    }

    @Override
    public void act(RitualContext ctx) throws RitualException {
        System.out.println(getName() + " готовится к жертвоприношению.");
    }

    public Weapon getKnife() {
        return knife;
    }
}

