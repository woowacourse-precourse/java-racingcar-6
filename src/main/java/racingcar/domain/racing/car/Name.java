package racingcar.domain.racing.car;

import static racingcar.domain.Constants.MAX_CAR_LENGTH;

import java.util.regex.Pattern;
import racingcar.util.ExceptionUtil;

/**
 * 자동차의 이름을 나타내는 불변 VO 객체입니다. 이름의 길이와 문자열 패턴을 검증합니다.
 */
public class Name {

    private final String NAME_LENGTH_OVER_MESSAGE = "이름의 길이가 초과되었습니다.";
    private final String ALPHA_NUMERIC_NAME_MESSAGE = "이름은 알파벳, 숫자만 가능합니다.";
    private final String name;

    /**
     * 주어진 이름으로 새로운 Name 인스턴스를 생성합니다. 이름이 형식에 맞는지 검증한 뒤 검증에 성공한 경우에만 생서앟ㅂ니다.
     *
     * @param name 자동차의 이름
     */
    private Name(String name) {
        validateName(name);
        this.name = name;
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

