package ritual;

import model.Character;
import model.characters.Prisoner;
import model.items.*;
import model.enums.RitualPhase;

import java.util.ArrayList;
import java.util.List;

public class RitualSite {
    private String name;
    private RitualPhase phase;
    private int smokeLevel;
    private List<Character> participants;
    private List<Prisoner> prisoners;
    private List<Fire> fires;
    private List<Cauldron> cauldrons;
    private SacredTree sacredTree;
    private Idol idol;
    private GoldenBaba goldenBaba;
    private Veil veil;

    public RitualSite(String name) {
        this.name = name;
        this.phase = RitualPhase.PREP;
        this.smokeLevel = 5;
        this.participants = new ArrayList<>();
        this.prisoners = new ArrayList<>();
        this.fires = new ArrayList<>();
        this.cauldrons = new ArrayList<>();
    }

    public void advancePhase() {
        switch (phase) {
            case PREP -> phase = RitualPhase.CHANT;
            case CHANT -> phase = RitualPhase.OFFERING;
            case OFFERING -> phase = RitualPhase.DIVINATION;
            case DIVINATION -> phase = RitualPhase.REVEAL;
            case REVEAL -> phase = RitualPhase.SACRIFICE;
            case SACRIFICE -> phase = RitualPhase.FINISH;
            case FINISH -> {
                // Уже финал
            }
        }
        System.out.println("Ритуальная фаза переходит в: " + phase);
    }

    public void updateSmoke(int delta) {
        smokeLevel += delta;
        System.out.println("Общий уровень дыма на поляне: " + smokeLevel);
    }

    public String getName() {
        return name;
    }

    public RitualPhase getPhase() {
        return phase;
    }

    public int getSmokeLevel() {
        return smokeLevel;
    }

    public List<Character> getParticipants() {
        return participants;
    }

    public void addParticipant(Character c) {
        participants.add(c);
    }

    public List<Prisoner> getPrisoners() {
        return prisoners;
    }

    public void addPrisoner(Prisoner p) {
        prisoners.add(p);
    }

    public List<Fire> getFires() {
        return fires;
    }

    public void addFire(Fire f) {
        fires.add(f);
    }

    public List<Cauldron> getCauldrons() {
        return cauldrons;
    }

    public void addCauldron(Cauldron c) {
        cauldrons.add(c);
    }

    public SacredTree getSacredTree() {
        return sacredTree;
    }

    public void setSacredTree(SacredTree tree) {
        this.sacredTree = tree;
    }

    public Idol getIdol() {
        return idol;
    }

    public void setIdol(Idol idol) {
        this.idol = idol;
    }

    public GoldenBaba getGoldenBaba() {
        return goldenBaba;
    }

    public void setGoldenBaba(GoldenBaba baba) {
        this.goldenBaba = baba;
    }

    public Veil getVeil() {
        return veil;
    }

    public void setVeil(Veil veil) {
        this.veil = veil;
    }
}

