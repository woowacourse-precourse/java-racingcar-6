package racingcar.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public static final String ERROR_DUPLICATION = "입력은 중복 없이 이루어져야 합니다.";
    public static final String ERROR_FIVE_LENGTH = "입력은 5글자 이하로 이루어져야 합니다.";
    public static final String ERROR_BLANK = "입력은 빈칸 없이 이루어져야 합니다.";
    public static final String ERROR_NOT_NUMBER = "입력은 숫자로 이루어져야 합니다.";
    public static final String ERROR_NEGATIVE = "입력은 1이상으로 이루어져야 합니다.";
    public static final int LIMIT_LENGTH = 5;

    private static Validate validate;

    private Validate() {
    }

    public static Validate getInstance() {
        if (validate == null) {
            synchronized (Validate.class) {
                if (validate == null) {
                    validate = new Validate();
                }
            }
        }
        return validate;
    }

    public void validateDuplicationCarsName(List<String> input) throws IllegalArgumentException {
        Set<String> nameSet = new HashSet<>(input);

        if (nameSet.size() != input.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATION);
        }
    }

    public void validateLengthCarsName(List<String> input) throws IllegalArgumentException {
        for (String s : input) {
            if (s.length() > LIMIT_LENGTH) {
                throw new IllegalArgumentException(ERROR_FIVE_LENGTH);
            }
        }
    }

    public void validateBlankCarsName(List<String> input) throws IllegalArgumentException {
        for (String s : input) {
            if (s.contains(" ")) {
                throw new IllegalArgumentException(ERROR_BLANK);
            }
        }
    }

    public void validateIsNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    public void validateNegativeNumber(String input) throws IllegalArgumentException {
        int number = Integer.parseInt(input);

        if (number < 1) {
            throw new IllegalArgumentException(ERROR_NEGATIVE);
        }
    }
}
