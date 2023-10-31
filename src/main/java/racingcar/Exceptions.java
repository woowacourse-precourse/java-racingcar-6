package racingcar;

public enum Exceptions {
    OVER_5ARG("참가자 이름은 5자를 넘을 수 없습니다."),
    DUPLICATION("참가자 이름은 중복 되 수 없습니다."),
    INPUT_IS_NOT_INTEGER("시행 회수는 자연수를 입력해야 합니다."),
    INPUT_IS_NOT_OVER_ZERO("시행 회수는 0 이상이여야 합니다.");


    private final String errMessage;

    Exceptions(String errMessage) {
        this.errMessage = errMessage;
    }

    public String errMessage() {
        return errMessage;
    }
}
