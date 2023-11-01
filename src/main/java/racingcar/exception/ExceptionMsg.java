package racingcar.exception;

public enum ExceptionMsg {
    OVER_FIVE_CAR_NAME("자동차의 이름이 5글자를 초과했습니다.\n"),
    NULL_INPUT("아무런 입력이 없습니다.\n"),

    NOT_POSSITIVE_TRY("시도할 횟수가 음수입니다\n"),
    INVALID_CAR_NAME("자동차 이름은 문자로만 구성되어야 합니다.\n"),
    DUPLICATE_CAR_NAME("중복된 자동차 이름을 입력할 수 없습니다.\n"),
    MINIMUM_TWO_CARS_REQUIRED("적어도 두 대 이상의 자동차를 입력해야 합니다.\n");




    private final String message;

    ExceptionMsg(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }


}
