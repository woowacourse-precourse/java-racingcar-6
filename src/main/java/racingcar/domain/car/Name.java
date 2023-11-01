package racingcar.domain.car;

import static racingcar.domain.Constants.MAX_CAR_LENGTH;

import java.util.regex.Pattern;
import racingcar.util.ExceptionUtil;

public class Name { // 원시값 대신 VO 사용

    private final String NAME_LENGTH_OVER_MESSAGE = "이름의 길이가 초과되었습니다.";
    private final String ALPHA_NUMERIC_NAME_MESSAGE = "이름은 알파벳, 숫자만 가능합니다.";
    private final String name; // 불변!

    private Name(String name) {
        validateName(name);
        this.name=name;
    }

    public static Name create(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }


    private void validateNameLength(String name) {
        if (name.length() > MAX_CAR_LENGTH) {
            ExceptionUtil.throwInvalidValueException(NAME_LENGTH_OVER_MESSAGE);
        }
    }

    private void validateAlphaNumeric(String name) {
        if (!Pattern.matches("^[a-zA-Z0-9]*$", name)) {
            ExceptionUtil.throwInvalidValueException(ALPHA_NUMERIC_NAME_MESSAGE);
        }
    }

    private void validateName(String name) {
        validateNameLength(name);
        validateAlphaNumeric(name);
    }
}
