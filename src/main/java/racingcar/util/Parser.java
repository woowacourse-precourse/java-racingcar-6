package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public List<String> parseCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int parseTrialNumber(String input) {
        return Integer.parseInt(input);
    }

}
