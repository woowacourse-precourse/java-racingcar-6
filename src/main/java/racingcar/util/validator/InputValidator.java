package racingcar.util.validator;

import static racingcar.util.ConstantNumbers.MAXIMUM_NAME_LENGTH;
import static racingcar.util.ConstantNumbers.MINIMUM_TRY_COUNT;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.exception.ErrorMessage;
import racingcar.util.exception.RacingCarException;

public class InputValidator implements Validator {
    InputValidator() {
    }

    /**
     * 주어진 이름 문자열 리스트가 유효한 리스트인지 확인하는 메서드.
     * 이름의 길이가 1 ~ 5자인지와 중복된 이름이 있는지 확인하고,
     * 유효하지 않으면 IllegalArgumentException 예외를 던진다.
     *
     * @param names 이름 문자열 리스트
     */
    public void isValidList(final List<String> names) {
        if (!hasValidNames(names)) {
            throw RacingCarException.of(ErrorMessage.INVALID_NAME);
        }

        if (!hasDistinctName(names)) {
            throw RacingCarException.of(ErrorMessage.DUPLICATE_NAME);
        }
    }

    /**
     * 주어진 문자열이 음이 아닌 정수인지 확인하고,
     * 음이 아닌 정수라면 정수 값을 반환하는 메서드.
     * 숫자가 아니거나, 음이 아닌 정수가 아니면
     * IllegalArgumentException 예외를 던진다.
     *
     * @param count 숫자로 이루어진 문자열
     * @return int 타입 정수
     */
    public int isNonNegativeInteger(final String count) {
        int number;
        try {
            number = Integer.parseInt(count);
        } catch (Exception e) {
            throw RacingCarException.of(ErrorMessage.NOT_INTEGER);
        }

        if (isNegative(number)) {
            throw RacingCarException.of(ErrorMessage.NOT_POSITIVE);
        }

        return number;
    }

    private boolean hasValidNames(final List<String> names) {
        for (String name : names) {
            if (name.isBlank() || name.length() > MAXIMUM_NAME_LENGTH.number()) {
                return false;
            }
        }

        return true;
    }

    private boolean hasDistinctName(final List<String> names) {
        List<String> checkList = new ArrayList<>();
        for (String name : names) {
            if (checkList.contains(name)) {
                return false;
            }
            checkList.add(name);
        }

        return true;
    }

    private boolean isNegative(final int number) {
        return number < MINIMUM_TRY_COUNT.number();
    }
}
