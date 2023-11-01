package racingcar.constant;

public enum ExceptionMeaage {
    SEPARATOR_EXCEPTION("쉽표(,)를 통해 구분해 주세요."),
    CARS_SIZE_EXCEPTION("자동차는 2대 이상이 경기에 참여해야 합니다."),
    CAR_NAME_OF_LENGTH_EXCEPTION("이름은 5자 이하만 가능합니다."),
    MOVING_NUMBER_EXCEPTION("숫자외 다른 문자는 쓸 수 없습니다.");

    private String message;

    private ExceptionMeaage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
