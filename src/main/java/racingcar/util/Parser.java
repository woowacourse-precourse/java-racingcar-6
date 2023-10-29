package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    Validator validator = new Validator();

    public int parseNumTrial(String numTrialInput) {
        validator.validateNumTrialInput(numTrialInput);
        return Integer.parseInt(numTrialInput);
    }

    public List<String> parseCarNames(String carNamesInput) {
        validator.validateCarNamesInput(carNamesInput);
        return Arrays.asList(carNamesInput.split(","));
    }
}
