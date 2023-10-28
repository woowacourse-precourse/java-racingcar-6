package racingcar.common;

import java.util.List;

public class InputValidator {

    public List<String> convertNames(String input) {
        String[] names = checkBoundary(input).split(",");

        for (String name : names) {
            checkConditions(name);
        }
        return List.of(names);
    }

    public int convertCount(String input) {
        int count = changeInteger(input);

        if (count > 0) {
            return count;
        }
        throw new IllegalArgumentException();
    }

    private String checkBoundary(String input) {
        if (input.charAt(0) == ',' || input.charAt(input.length()-1) == ',') {
            throw new IllegalArgumentException();
        }
        return input;
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

}
