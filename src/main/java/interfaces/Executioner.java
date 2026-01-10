package interfaces;

import model.characters.Prisoner;
import exceptions.RitualException;
import ritual.RitualContext;

public interface Executioner {
    void execute(Prisoner p, RitualContext ctx) throws RitualException;
}

