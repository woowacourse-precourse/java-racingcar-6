package racingcar.common.exception;

import racingcar.common.config.RacingCarRule;

public enum ErrorMessage {
    BLANK_INPUT("공백이 아닌 문자를 입력해주세요."),
    INVALID_NUMERIC_INPUT("숫자로만 입력해주세요."),
    INVALID_LENGTH_INPUT("유효하지 않은 입력 길이입니다. 다시 입력해주세요."),
    INVALID_RACING_CAR_NAME_LENGTH(
            String.format("이름은 공백이 아니어야 하며, %d글자 이하여야 합니다.", RacingCarRule.MAX_RACER_NAME_LENGTH)),
    INVALID_RACING_CAR_NAME_FORMAT("이름은 알파벳이나 숫자로만 이루어져야 합니다."),
    INVALID_RACER_SIZE(
            String.format("등록할 수 있는 자동차는 최소 %d, 최대 %d개입니다.",
                    RacingCarRule.MIN_RACER_SIZE, RacingCarRule.MAX_RACER_SIZE)),
    DUPLICATED_RACING_CAR_NAME("자동차 이름은 서로 중복되지 않아야 합니다."),
    MIN_RACER_SIZE_FOR_RACING_GAME("자동차 경주에 참여할 자동차는 두 대 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public RacingCarException getException() {
        return new RacingCarException(this.message);
    }
}
