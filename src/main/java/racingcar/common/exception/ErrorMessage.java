package racingcar.common.exception;

import racingcar.common.config.RacingCarRule;

public enum ErrorMessage {
    BLANK_INPUT("공백이 아닌 문자를 입력해주세요."),
    INVALID_NUMERIC_INPUT("숫자로만 입력해주세요."),
    INVALID_LENGTH_INPUT("유효하지 않은 입력 길이입니다."),
    INVALID_RACER_NAME_LENGTH(
            String.format("이름은 %d글자 이하여야 합니다.", RacingCarRule.MAX_RACER_NAME_LENGTH)),
    INVALID_RACER_NAME_FORMAT("이름은 알파벳이나 숫자로만 이루어져야 합니다."),
    INVALID_RACER_SIZE(
            String.format("등록할 수 있는 수는 최소 %d개, 최대 %d개입니다.",
                    RacingCarRule.MIN_RACER_SIZE, RacingCarRule.MAX_RACER_SIZE)),
    DUPLICATED_RACER_NAME("이름은 서로 중복되지 않아야 합니다."),
    INVALID_TOTAL_TURN_SIZE(String.format("최대 시도 횟수는 %d입니다.", RacingCarRule.MAX_TOTAL_TURN));
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public RacingCarException getException() {
        return new RacingCarException(this.message);
    }

    public RacingCarException getException(String invalidInput) {
        return new RacingCarException(this.message + " : " + invalidInput);
    }
}
