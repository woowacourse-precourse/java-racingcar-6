package racingcar.util;

import static racingcar.util.ConstantNumbers.MAXIMUM_NAME_LENGTH;

import java.util.List;

public class InputValidator implements Validator {
    InputValidator() {}
    public void isValidList(final List<String> names) {
        for (String name:names) {
            if (!isValidName(name)) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public Integer isInteger(final String count) {
        int number;
        try {
            number = Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
        return number;
    }
    private boolean isValidName(final String name) {
        return !name.isBlank() && name.length() <= MAXIMUM_NAME_LENGTH.number();
    }
}
