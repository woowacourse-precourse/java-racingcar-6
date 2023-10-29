package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public int parseNumGames(String numRacesInput) {
        return Integer.parseInt(numRacesInput);
    }

    public List<String> parseCarNames(String carNamesInput) {
        return Arrays.asList(carNamesInput.split(","));
    }
}
