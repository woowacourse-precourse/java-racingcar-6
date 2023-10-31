package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractElementUtil {

    public List<String> extractCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int extractTrialNumber(String input) {
        return Integer.parseInt(input);
    }
}
