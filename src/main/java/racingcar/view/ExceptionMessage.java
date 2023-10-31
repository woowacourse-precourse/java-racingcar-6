package racingcar.view;

public enum ExceptionMessage {
    NOT_NULL("이름이 null이 될 수 없습니다!"),
    NOT_OVER_FIVE("이름은 5자 이상이 될 수 없습니다!"),
    NOT_KOREAN_OR_ENGLISH("입력값은 영어나 한글만 가능합니다."),
    NOT_NUMBER_FORMAT("숫자를 입력해주세요."),
    NOT_LESS_THAN_ZERO("최소 한번 이상 이동해야합니다");
    private String message;

    ExceptionMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
