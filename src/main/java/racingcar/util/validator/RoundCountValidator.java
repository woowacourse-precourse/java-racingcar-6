package racingcar.util.validator;

import racingcar.exception.RoundCountInvalidException;

public class RoundCountValidator {

    private static final int MIN_ROUND_COUNT = 1;
    private static final String ROUND_COUNT_NOT_NUMBER = "시도 횟수를 정수로 변환할 수 없습니다.";
    private static final String COUNT_NOT_POSITIVE = "시도 횟수가 자연수가 아닙니다.";

    public static void validate(String roundCount) {
        try {
            int parsedRoundCount = Integer.parseInt(roundCount);
            if (parsedRoundCount < MIN_ROUND_COUNT) {
                throw new RoundCountInvalidException(COUNT_NOT_POSITIVE);
            }
        } catch (NumberFormatException exception) {
            throw new RoundCountInvalidException(ROUND_COUNT_NOT_NUMBER);
        }
    }
}
