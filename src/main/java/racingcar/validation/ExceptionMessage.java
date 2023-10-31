package racingcar.validation;

public enum ExceptionMessage {

    CAR_NAME_LENGTH("자동차의 이름은 1자 이상, 5자 이하여야 합니다.")
    ,CAR_NAME_DUPLICATION("자동차의 이름은 중복될 수 없습니다.")
    ,CAR_NAME_TYPE("자동차의 이름은 특수문자를 제외한 문자와 숫자만 허용합니다.")
    ,GAME_COUNT_TYPE("게임 횟수는 자연수여야 한다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
