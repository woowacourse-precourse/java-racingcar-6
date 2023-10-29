package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public int parseNumTrial(String numTrialInput) {
        return Integer.parseInt(numTrialInput);
    }

    public List<String> parseCarNames(String carNamesInput) {
        return Arrays.asList(carNamesInput.split(","));
    }
}
