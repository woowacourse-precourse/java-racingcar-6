package racingcar.exception;

public interface ExceptionMessage {
    enum CarException {
        NAME_MUST_BE_EXISTS("이름이 존재하지 않습니다."),
        INVALID_NAME_LENGTH("자동차는 5자 이하의 이름을 가질 수 있습니다."),
        ;

        public final String message;

        CarException(final String message) {
            this.message = message;
        }
    }
}
