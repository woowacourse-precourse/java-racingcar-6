package racingcar.exception;

/**
 * <p>시도 횟수가 올바르지 않을 경우 발생하는 예외 클래스입니다.</p>
 */
public class InvalidAttemptCountException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "시도할 회수는 양의 정수여야 합니다.";

    private static final int MIN_BOUND = 0;

    /**
     * <p>기본 메시지를 사용하여 예외 객체를 생성합니다.</p>
     */
    public InvalidAttemptCountException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * <p>지정된 메시지를 사용하여 예외 객체를 생성합니다.</p>
     *
     * @param message 예외 메시지
     */
    public InvalidAttemptCountException(String message) {
        super(message);
    }

    /**
     * <p>시도 횟수가 유효한 값인지 검증합니다.</p>
     *
     * <p>시도 횟수가 0 이하일 경우 {@link InvalidAttemptCountException}을 발생시킵니다.</p>
     *
     * @param attemptCount 검증할 시도 횟수
     * @throws InvalidAttemptCountException 시도 횟수가 0 이하일 경우 발생
     */
    public static void validate(int attemptCount) {
        if (attemptCount <= MIN_BOUND) {
            throw new InvalidAttemptCountException();
        }
    }
}
