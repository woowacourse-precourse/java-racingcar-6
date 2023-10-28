package racingcar.common;

import java.util.List;

public class InputValidator {

    public List<String> convertNames(String input) {
        List<String> names = getNameList(input);

        for (String name : names) {
            checkConditions(name);
        }
        return names;
    }

    public int convertCount(String input) {
        int count = changeInteger(input);

        if (count > 0) {
            return count;
        }
        throw new IllegalArgumentException();
    }

    private void checkConditions(String name) {
        if (name.length() > Size.CAR_NAME.getValue() || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private int changeInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private List<String> getNameList(String input) {
        return List.of(checkBoundary(input).split(","));
    }

    private String checkBoundary(String input) {
        if (input.charAt(0) == ',' || input.charAt(input.length()-1) == ',') {
            throw new IllegalArgumentException();
        }
        return input;
    }

}
