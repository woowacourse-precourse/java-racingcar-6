package racingcar.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
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
            throw new IllegalArgumentException("자동차 이름 중복 허용 X");
        }
    }
    public void validateLengthCarsName(List<String> input) throws IllegalArgumentException {
        for (String s : input) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5이하");
            }
        }
    }
    public void validateBlankCarsName(List<String> input) throws IllegalArgumentException {
        for (String s : input) {
            if (s.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함 X");
            }
        }
    }
    public void validateIsNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형태만 입력 가능");
        }
    }

    public void validateNegativeNumber(String input) throws IllegalArgumentException {
        int number = Integer.parseInt(input);

        if (number < 1) {
            throw new IllegalArgumentException("반복할 횟수 1 초과만 입력 가능");
        }
    }
}
