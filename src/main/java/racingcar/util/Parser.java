package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public int parseNumGames(String numGamesInput) {
        return Integer.parseInt(numGamesInput);
    }

    public List<String> parseCarNames(String carNamesInput) {
        return Arrays.asList(carNamesInput.split(","));
    }
}
