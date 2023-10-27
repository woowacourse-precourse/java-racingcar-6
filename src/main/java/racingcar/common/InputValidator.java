package racingcar.common;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public List<String> checkNames(String input) {
        String[] names = checkBoundary(input).split(",");
        for (String name : names) {
            if (name.length() > Size.CAR_NAME.getValue() || name.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
        return new ArrayList<>(List.of(names));
    }

    public int checkCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count > 0) {
                return count;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        throw new IllegalArgumentException();
    }

    private String checkBoundary(String input) {
        if (input.charAt(0) == ',' || input.charAt(input.length()-1) == ',') {
            throw new IllegalArgumentException();
        }
        return input;
    }

}
