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

    enum GameTryCountException {
        TRY_COUNT_MUST_BE_AT_LEAST_ONE("게임 시도 횟수는 최소 1번 이상이여야 합니다."),
        ;

        public final String message;

        GameTryCountException(final String message) {
            this.message = message;
        }
    }
}
