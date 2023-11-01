package racingcar.message;

public enum RacingCarErrorMessage {
    NOT_CAR_NAME_LENGTH_CORRECT("자동차이름은 1자리이상 5자 이하만 가능합니다."),
    NOT_NATURAL_NUMBER_VALIDATE("이동할 횟수는 자연수여야 한다."),
    DUPLICATED_CAR_NAME("자동차 이름은 중복으로 사용될 수 없습니다."),
    NOT_MIN_CAR_COUNT("자동차는 최소 2대 이상 생성해야 합니다."),
    CAR_LIST_EMPTY("차량 리스트가 비었습니다.");

    String message;

    RacingCarErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
