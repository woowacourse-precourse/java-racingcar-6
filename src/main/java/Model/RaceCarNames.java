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
         List<String> carNames = Arrays.asList(raceCarNames.split(","));
         carNames.replaceAll(String::trim);

         return carNames;
    }

    public boolean isEndsWithComma() {
        return raceCarNames.endsWith(",");
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
