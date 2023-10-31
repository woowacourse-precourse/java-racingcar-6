package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parsing {

    public List<String> parseCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
}
