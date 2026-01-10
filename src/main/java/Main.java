import model.Character;
import model.characters.*;
import model.items.*;
import model.records.*;
import model.enums.*;
import exceptions.*;
import ritual.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== РИТУАЛ У СВЯЩЕННОЙ ЕЛИ ===\n");

        RitualSite site = new RitualSite("Поляна у священной ели");
        Ukhvat ukhvat = new Ukhvat("Ухват");
        
        List<Shaman> shamans = new ArrayList<>();
        shamans.add(new Shaman("Шаман 1"));
        shamans.add(new Shaman("Шаман 2"));
        
        List<Warrior> warriors = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Weapon weapon = new Weapon("Оружие воина " + i, WeaponType.SWORD, 100);
            warriors.add(new Warrior("Воины " + i, weapon));
        }
        
        VoglePrince prince = new VoglePrince("Князь");
        
        List<PrinceTeen> princeTeens = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Weapon knife = new Weapon("Нож княжича " + i, WeaponType.KNIFE, 100);
            princeTeens.add(new PrinceTeen("Княжич " + i, knife));
        }
        
        List<Prisoner> prisoners = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            prisoners.add(new Prisoner("Пленник " + i));
        }
        
        site.addParticipant(ukhvat);
        for (Shaman s : shamans) {
            site.addParticipant(s);
        }
        for (Warrior w : warriors) {
            site.addParticipant(w);
        }
        site.addParticipant(prince);
        for (PrinceTeen pt : princeTeens) {
            site.addParticipant(pt);
        }
        for (Prisoner p : prisoners) {
            site.addPrisoner(p);
        }
        
        Fire fire1 = new Fire("Костёр 1");
        Fire fire2 = new Fire("Костёр 2");
        Fire mainFire = new Fire("Большой костёр");
        site.addFire(fire1);
        site.addFire(fire2);
        site.addFire(mainFire);
        
        Cauldron cauldron = new Cauldron("Котёл");
        site.addCauldron(cauldron);
        
        SacredTree tree = new SacredTree("Священная ель");
        site.setSacredTree(tree);
        
        Idol idol = new Idol("Идол", 80);
        site.setIdol(idol);
        
        GoldenBaba goldenBaba = new GoldenBaba("Золотая Баба", 100);
        site.setGoldenBaba(goldenBaba);
        
        Veil veil = new Veil("Полог");
        site.setVeil(veil);
        
        RitualContext ctx = new RitualContext(site);
        
        System.out.println("На поляне у священной ели собраны:");
        System.out.println("- " + ukhvat.getName());
        System.out.println("- 2 шамана");
        System.out.println("- группа воинов");
        System.out.println("- " + prince.getName());
        System.out.println("- 3 княжича");
        System.out.println("- 3 пленника");
        System.out.println("Горят костры, рядом котёл. Золотая Баба закрыта пологом и спрятана в дупле.");
        System.out.println("Дым пока умеренный, но растёт.\n");
        
        // ЕЙСТВИЕ ПЕРВОЕ -- СТАРТ РИТУАЛА
        System.out.println("=== ДЕЙСТВИЕ ПЕРВОЕ. СТАРТ РИТУАЛА ===");
        site.advancePhase(); // PREP -> CHANT
        
        ukhvat.crossSelf();
        
        System.out.println("Камлание начинается.");
        for (Shaman shaman : shamans) {
            shaman.dance();
        }
        
        System.out.println("Воины подхватывают ритм:");
        for (int i = 0; i < warriors.size() / 2; i++) {
            warriors.get(i).chant();
        }
        System.out.println("Кто-то стоит молча.");
        System.out.println("Потом резко переходят на крики и поднимают оружие.");
        for (Warrior warrior : warriors) {
            warrior.scream();
        }
        
        if (ukhvat.getCourage() < 30) {
            ukhvat.setCourage(15);
            System.out.println("У Ухвата низкая смелость - он сразу уходит в страх и держится чуть поодаль.");
        }
        
        System.out.println();
        
        // ЕЙСТВИЕ ВТОРОЕ. РИТУАЛ ПРОДОЛЖАЕТСЯ
        System.out.println("=== ДЕЙСТВИЕ ВТОРОЕ. РИТУАЛ ПРОДОЛЖАЕТСЯ ===");
        site.advancePhase(); // CHANT -> OFFERING
        
        for (Fire fire : site.getFires()) {
            fire.ignite();
        }
        
        Ingredient salt = new Ingredient(IngredientType.SALT, 10);
        try {
            shamans.get(0).castSalt(fire1, salt);
        } catch (RitualException e) {
            System.out.println(e.getMessage());
        }
        
        int smokeIncrease = ctx.nextInt(30) + 10;
        site.updateSmoke(smokeIncrease);
        
        if (site.getSmokeLevel() > 40) {
            System.out.println("Дым быстро поднялся!");
            ukhvat.sneeze();
        }
        
        System.out.println();
        
        // ДЕЙСТВИЕ ТРЕТЬЕ -- КОТЁЛ
        System.out.println("=== ДЕЙСТВИЕ ТРЕТЬЕ. КОТЁЛ ===");
        
        cauldron.add(new Ingredient(IngredientType.ROOTS, 5));
        cauldron.add(new Ingredient(IngredientType.LEAVES, 8));
        cauldron.add(new Ingredient(IngredientType.BARK, 3));
        if (ctx.chance(0.5)) {
            cauldron.add(new Ingredient(IngredientType.FLY_AGARIC, 2));
        }
        
        cauldron.boil();
        
        List<Drink> drinks = new ArrayList<>();
        for (Warrior warrior : warriors) {
            try {
                Drink drink = cauldron.scoop();
                drinks.add(drink);
                warrior.drink(drink);
                
                if (drink.potency() > 50) {
                    Mug mug = new Mug("Кружка");
                    try {
                        mug.fill(drink);
                    } catch (RitualException e) {
                        System.out.println(e.getMessage());
                    }
                    mug.breakOn(idol);
                }
            } catch (RitualException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println();
        
        // ГАДАНИЕ
        System.out.println("=== ДЕЙСТВИЕ ЧЕТВЁРТОЕ. ГАДАНИЕ ===");
        site.advancePhase(); // OFFERING -> DIVINATION
        
        Prophecy prophecy = null;
        try {
            prophecy = shamans.get(1).predict(ctx);
        } catch (RitualException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println();
        
        // ЗАКАТ, ЛУЧ В ЕЛЬ, ОТКРЫТИЕ ПОЛОГА
        System.out.println("=== ДЕЙСТВИЕ ПЯТОЕ. ЗАКАТ, ЛУЧ В ЕЛЬ, ОТКРЫТИЕ ПОЛОГА ===");
        site.advancePhase(); // DIVINATION -> REVEAL
        
        tree.hitBySun(site);
        
        System.out.println("Толпа отвечает всплеском (крики, шум, возможно стрелы со свистом):");
        for (Warrior warrior : warriors) {
            warrior.scream();
        }
        
        veil.open();
        
        try {
            goldenBaba.reveal();
        } catch (RitualException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            ukhvat.approach(goldenBaba);
        } catch (PanicException e) {
            System.out.println(e.getMessage());
            ukhvat.changeEmotion(Emotion.FEAR);
        }
        
        System.out.println();
        
        // ДЕЙСТВИЕ ШЕСТОЕ. СКРЫТИЕ ЗОЛОТОЙ БАБЫ И ИДОЛ В КОСТРЕ
        System.out.println("=== ДЕЙСТВИЕ ШЕСТОЕ. СКРЫТИЕ ЗОЛОТОЙ БАБЫ И ИДОЛ В КОСТРЕ ===");
        
        goldenBaba.hide();
        veil.close();
        System.out.println("В центре внимания остается идол в большом костре.");
        System.out.println("Воины начинают кружиться вокруг костра и рубят идол, срезая щепки.");
        while (idol.getIntegrity() > 0) {
            int chips = 10 + ctx.nextInt(10);
            try {
                warriors.get(ctx.nextInt(warriors.size())).carveIdol(idol, chips);
            } catch (RitualException e) {
                System.out.println(e.getMessage());
                break;
            }
            if (idol.getIntegrity() <= 0) {
                break;
            }
        }
        
        System.out.println();
        
        // ПЛЕННИКИ И СИГНАЛ КНЯЗЯ
        System.out.println("=== ДЕЙСТВИЕ СЕДЬМОЕ. ПЛЕННИКИ И СИГНАЛ КНЯЗЯ ===");
        site.advancePhase(); // REVEAL -> SACRIFICE
        
        System.out.println("Толпа резко перемещается к ямам/месту, где стоят пленники, привязанные и обессиленные.");
        prince.signalStartSacrifice(site);
        System.out.println("Пленники очухиваются от дыма:");
        for (Prisoner prisoner : prisoners) {
            prisoner.awakenFromSmoke(site.getSmokeLevel());
        }
        
        System.out.println();
        
        // ===== ДЕЙСТВИЕ ВОСЬМОЕ. ДЕЙСТВИЕ КНЯЖИЧЕЙ (КУЛЬМИНАЦИЯ) =====
        System.out.println("=== ДЕЙСТВИЕ ВОСЬМОЕ. ДЕЙСТВИЕ КНЯЖИЧЕЙ (КУЛЬМИНАЦИЯ) ===");
        
        boolean firstKill = false;
        
        for (int i = 0; i < Math.min(princeTeens.size(), prisoners.size()); i++) {
            Prisoner prisoner = prisoners.get(i);
            if (prisoner.getHealth() > 0) {
                try {
                    princeTeens.get(i).execute(prisoner, ctx);
                    
                    if (!firstKill && prisoner.getHealth() <= 0) {
                        firstKill = true;
                        System.out.println("Ухват не выдерживает и отворачивается (после первого успешного удара).");
                        ukhvat.changeEmotion(Emotion.FEAR);
                    }
                    while (prisoner.getHealth() > 0) {
                        try {
                            princeTeens.get(i).execute(prisoner, ctx);
                        } catch (RitualException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (RitualException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
        System.out.println();
        
        // ФИНАЛ
        System.out.println("=== ДЕЙСТВИЕ ДЕВЯТОЕ. ФИНАЛ ===");
        site.advancePhase(); // SACRIFICE -> FINISH
        
        System.out.println("Дым и чад окончательно накрывают поляну.");
        site.updateSmoke(50);
        System.out.println("Ритуал завершается -> участники выдыхаются, эмоции спадают или переходят в \"опустошение\".");
        
        for (Character participant : site.getParticipants()) {
            if (participant.getStamina() > 0) {
                participant.changeEmotion(Emotion.EXHAUSTED);
            }
        }
        
        System.out.println("\n=== РИТУАЛ ЗАВЕРШЁН ===");
    }
}
