package racingcar.constant.message;

public enum InvalidNameMessage {
    DUPLICATE("이름이 중복되었습니다."),
    LENGTH("1 ~ 5자리의 이름을 입력하세요."),
    ALPHABETIC("알파벳을 입력하세요."),
    MINIMUM_PARTICIPANTS("최소 두 명 이상의 참가자가 필요합니다.");

    private final String message;

    InvalidNameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
