package racingcar;

import java.util.List;

public class InputValidation {
    private static final int MAX_LENGTH = 5;

    public static void validateInput(String input) throws IllegalArgumentException {
        if (!input.matches("^[a-zA-Z,]*$")) {
            throw new IllegalArgumentException();
        }
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static void validateCarNames(List<String> carNames) throws IllegalArgumentException {
        for (String st : carNames) {
            if (st.length() > MAX_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }
}