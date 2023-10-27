package Model;

import java.util.Arrays;
import java.util.List;

public class RaceCarNames {
    public String raceCarNames;

    public RaceCarNames(String raceCarNames) {
        this.raceCarNames = raceCarNames;
    }

    public List<String> parseCarNamesFromRaceCarInput() {
        return Arrays.asList(raceCarNames.split(","));
    }

    // test용 method
    public boolean isRaceCarNamesEqual(String otherRaceCarNames) {
        if (raceCarNames == null) {
            return false;
        }
        return raceCarNames.equals(otherRaceCarNames);
    }

}
