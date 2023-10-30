package racingcar.validation;

import racingcar.exception.DuplicateNameException;
import racingcar.exception.MaxAttemptExceededException;
import racingcar.message.ErrorMessages;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    /**
     * input내의 중복원소 존재 유무를 검증
     */
    public void carName(String input) {
        String[] items = input.split(",");
        Set<String> uniqueItems = new HashSet<>();

        for (String s : items) {
            if (!uniqueItems.add(s)) {
                throw new DuplicateNameException(ErrorMessages.DUPLICATE_NAME.toString());
            }
        }
    }

    public void attemptCount(String input) {
        if (Integer.parseInt(input) > Integer.MAX_VALUE) {
            throw new MaxAttemptExceededException(ErrorMessages.MAX_ATTEMPT_EXCEED.toString());
        }
    }
}
