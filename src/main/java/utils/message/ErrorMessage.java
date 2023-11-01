package utils.message;

public enum ErrorMessage {
    CAR_NAME_PATTERN("자동차 이름은 영어와 한글로 이뤄져야합니다."),
    CAR_NAME_SIZE("자동차 이름은 1~5글자 사이여야합니다."),
    CAR_NAME_UNIQUE("자동차 이름은 중복될 수 없습니다."),
    ROUND_CNT_NUMBER("게임 회차는 숫자만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
