package racingcar.util;

import racingcar.exception.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Parser {

    public static List<String> splitName(String userInput, String regex) {
        return new ArrayList<>(Arrays.asList(userInput.split(regex)));
    }
}
