package racingcar.utils;

import racingcar.exception.InvalidAttemptCountException;

/**
 * 레이싱카 게임의 시도 횟수를 파싱하고 검증하는 유틸리티 클래스입니다.
 */
public class AttemptCountParser {

    /**
     * 주어진 문자열을 시도 횟수를 나타내는 정수로 파싱합니다. 유효하지 않거나 양수가 아닌 값에 대한 처리는
     * {@link InvalidAttemptCountException}에서 합니다.
     *
     * @param attemptCount 시도 횟수의 문자열 표현
     * @return 파싱된 시도 횟수의 정수 값
     * @throws InvalidAttemptCountException 입력값이 유효한 양의 정수가 아닐 경우
     */
    public static int parseAttemptCount(String attemptCount) {
        try {
            int parsedValue = Integer.parseInt(attemptCount);
            validate(parsedValue);
            return parsedValue;
        } catch (NumberFormatException e) {
            throw new InvalidAttemptCountException();
        }
    }

    /**
     * 주어진 시도 횟수가 양수인지 검증합니다. 값이 양수가 아닌 경우 {@link InvalidAttemptCountException}을 발생시킵니다.
     *
     * @param attemptCount 검증할 시도 횟수의 정수 값
     * @throws InvalidAttemptCountException 값이 양수가 아닐 경우
     */
    private static void validate(int attemptCount) {
        if (attemptCount <= 0) {
            throw new InvalidAttemptCountException();
        }
    }
}
