package racingcar;

import racingcar.model.Constants;
import racingcar.model.ExceptionMessages;

import java.util.*;

public class InputParser {
    public List<String> parseInput(String input) {
        List<String> names;
        names = Arrays.stream(input.trim().split(Constants.PARSER_REGEX)).toList();
        if (!validateList(names)) throw new IllegalArgumentException(ExceptionMessages.DUPLICATE_NAME_EXCEPTION);
        return names;
    }

    private boolean validateList(List<String> names) {
        Set<String> check = new HashSet<>();
        for (String name : names) {
            check.add(name);
        }
        return check.size() == names.size();
    }

}