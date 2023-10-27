package racingcar.constant;

public enum ErrorMessage {

    INVALID_CAR_NAME_INPUT("자동차 이름 입력값이 잘못 사용되었습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름의 길이가 잘못되었습니다."),
    NOT_NUMERIC("입력값이 숫자가 아닙니다."),
    INVALID_TRY_COUNT("시도 횟수가 잘못되었습니다."),
    INVALID_MAX_LOGIC("최대 이동 거리를 구하다 오류가 발생했습니다."),
    INVALID_ELEMENT_SIZE("자동차가 존재하지 않습니다."),
    INVALID_WINNER_NUM("우승자가 존재하지 않습니다.");


    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
