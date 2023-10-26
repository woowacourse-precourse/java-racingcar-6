package racingcar.exception;

public interface ExceptionMessage {
    enum CarException {
        INVALID_NAME_LENGTH("자동차는 5자 이하의 이름을 가질 수 있습니다."),
        ;

        public final String message;

        CarException(final String message) {
            this.message = message;
        }
    }
}
