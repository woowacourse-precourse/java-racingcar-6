package racingcar.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputValidator {

    static final int MAX_LENGTH = 5;

    public ArrayList<String> validateParticipant(String s) {
        Arrays
                .stream(s.split(","))
                .forEach(this::checkEmptyOrThrow);

        return Arrays
                .stream(s.split(","))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int validateCount(String s) {
        int value;
        try {
            value = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    void checkEmptyOrThrow(String s) {
        if (s.isEmpty() || s.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
