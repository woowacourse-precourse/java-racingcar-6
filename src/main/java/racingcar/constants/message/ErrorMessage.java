package racingcar.constants.message;

import static racingcar.model.Cars.DIVISION;

import racingcar.constants.RacingCarRole;

public enum ErrorMessage {

    DIVISION_CAR_NAME_ERROR(String.format("이름은 쉼표(%s) 기준으로 구분해야 합니다.", DIVISION)),
    CAR_NAME_LENGTH_ERROR(
        String.format("자동차 이름은 %s자 이하만 가능합니다.", RacingCarRole.MAX_CAR_NAME_LENGTH.getValue())),
    CARS_COUNT_ERROR(
        String.format("자동차 이름을 %s개 이상 입력해주세요", RacingCarRole.MIN_CARS_COUNT.getValue())),
    INPUT_NUMERIC_ERROR("숫자를 입력해 주세요"),
    NOT_FOUND_MAX_CAR_POSITION("레이싱카의 최대 위치를 찾지 못했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
