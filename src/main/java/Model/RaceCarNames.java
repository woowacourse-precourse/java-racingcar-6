package Model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RaceCarNames {
    private String raceCarNames;

    public RaceCarNames(String raceCarNames) {
        this.raceCarNames = raceCarNames;
    }

    public List<String> parseCarNamesFromInput() {
        return Arrays.asList(raceCarNames.split(","));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RaceCarNames other = (RaceCarNames) obj;
        return raceCarNames.equals(other.raceCarNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceCarNames);
    }
}
