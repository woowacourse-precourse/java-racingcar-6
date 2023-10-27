package Model;

import java.util.Arrays;
import java.util.List;

public class RaceCarNames {
    private String raceCarNames;

    public RaceCarNames(String raceCarNames) {
        this.raceCarNames = raceCarNames;
    }

    public List<String> parseCarNamesFromRaceCarInput() {
        return Arrays.asList(raceCarNames.split(","));
    }

    public String getRaceCarNames() {
        return raceCarNames;
    }
}
