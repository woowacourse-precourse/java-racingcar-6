package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public List<String> convertStringToList(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
}
