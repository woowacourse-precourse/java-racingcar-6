package racingcar.validation;

import racingcar.exception.DuplicateNameException;
import racingcar.exception.InvalidAttemptCountException;
import racingcar.exception.InvalidNameException;

import java.util.HashSet;
import java.util.Set;

import static racingcar.message.ErrorMessages.*;

/**
 * 사용자 입력에 대한 검증기
 */
public class InputValidator {

    /**
     * 이름에 공백만 존재하는지 검증
     * input내의 중복원소 존재 유무를 검증
     * 이름 길이가 5자리를 초과하는지 검증
     *
     * @param input - 사용자 입력
     */
    public void carName(String input) {
        String[] items = input.split(",");
        Set<String> uniqueItems = new HashSet<>();

        for (String item : items) {
            item = item.trim();
            if("".equals(item)) {
                throw new InvalidNameException(INVALID_NAME.toString());
            }
            if (item.length() > 5) {
                throw new InvalidNameException(INVALID_NAME_LENGTH.toString());
            }
            if (!uniqueItems.add(item)) {
                throw new DuplicateNameException(DUPLICATE_NAME.toString());
            }
        }
    }

    /**
     * 문자열을 전달받아 0 ~ Integer.MAXVALUE 사이의 정수값인지 검증
     *
     * @param attemptCount - 시도 횟수로 변환될 문자열
     */
    public void attemptCount(String attemptCount) {
        int intValue;
        try {
            intValue = Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new InvalidAttemptCountException(INVALID_ATTEMPT_COUNT.toString());
        }

        if (intValue <= 0) {
            throw new InvalidAttemptCountException(INVALID_ATTEMPT_COUNT.toString());
        }
    }
}
