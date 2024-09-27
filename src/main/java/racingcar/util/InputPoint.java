package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputPoint {

    public List<String> inputCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int inputTrial_Number(String input) {
        return Integer.parseInt(input);
    }
}