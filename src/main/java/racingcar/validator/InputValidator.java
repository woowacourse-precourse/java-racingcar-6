package racingcar.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputValidator {

    static final int MAX_LENGTH = 5;

    public static ArrayList<String> validateParticipant(String s) {
        Arrays
                .stream(s.split(","))
                .forEach(InputValidator::checkValidity);

        return Arrays
                .stream(s.split(","))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static int validateCount(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static void checkValidity(String s) {
        if (s.isEmpty() || s.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
