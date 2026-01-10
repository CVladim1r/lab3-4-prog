package interfaces;

import model.records.Prophecy;
import exceptions.RitualException;
import ritual.RitualContext;

public interface Diviner {
    Prophecy predict(RitualContext ctx) throws RitualException;
}

