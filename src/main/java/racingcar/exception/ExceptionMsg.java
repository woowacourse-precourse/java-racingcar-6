package racingcar.exception;

public enum ExceptionMsg {
    OVER_FIVE_CAR_NAME("자동차의 이름이 5글자를 초과했습니다.\n"),
    NULL_INPUT("아무런 입력이 없습니다.\n"),
    SAME_INPUT_CAR("동일한 이름의 자동차가 있습니다\n"),
    NOT_POSSITIVE_TRY("시도할 횟수가 음수입니다\n");




    private final String message;

    ExceptionMsg(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }


}
