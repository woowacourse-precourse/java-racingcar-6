package racingcar.constant;

public enum ExceptionType {
    NAME("이름 형식이 잘못된 것 같아요. 공백이 포함되지 않은 1글자 이상 5글자 이내의 문자열을 입력해 주세요."),
    NUMBER("횟수 입력이 잘못된 것 같아요. 이동 횟수는 자연수로만 이루어져야 해요.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
