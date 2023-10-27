package Model;

import camp.nextstep.edu.missionutils.Console;

public class RaceCarNames {
    public String raceCarNames;

    public RaceCarNames(String raceCarNames) {
        this.raceCarNames = raceCarNames;
    }

    // test용 method
    public boolean isRaceCarNamesEqual(String otherRaceCarNames) {
        if (raceCarNames == null) {
            return false;
        }
        return raceCarNames.equals(otherRaceCarNames);
    }

}
