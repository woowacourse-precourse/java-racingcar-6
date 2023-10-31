package racingcar.validator;



import java.util.Arrays;
import java.util.stream.Stream;

import static racingcar.util.MagicNumber.MAX_NAME_LENGTH;
import static racingcar.util.MagicNumber.MIN_NAME_LENGTH;

public class InputValidator {

    public void validateCarName(String names) {
        validateCarNameEmptyOrNull(names);
        validateCarNameLength(names);
    }

    public void validateCarNameEmptyOrNull(String names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있으면 안됩니다.");
        }
    }

    public void validateCarNameLength(String names) {
        Stream<String> nameStream = Arrays.stream(names.split(",")).map(String::trim);

        nameStream.forEach(name -> {
            if (name.length() < MIN_NAME_LENGTH.getNumber() || name.length() > MAX_NAME_LENGTH.getNumber()) {
                throw new IllegalArgumentException("자동차 이름의 길이는 1에서 5 사이여야 합니다.");
            }
        });
    }

    public void validateTryNumber(String tryNumber) {
        validateTryNumberEmptyOrNull(tryNumber);
        validateTryNumberIsNumber(tryNumber);
    }

    public void validateTryNumberEmptyOrNull(String tryNumber) {
        if (tryNumber == null || tryNumber.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 비어있으면 안됩니다.");
        }
    }

    public void validateTryNumberIsNumber(String tryNumber) {
        try {
            Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 된 문자열 입니다.");
        }
    }
}
