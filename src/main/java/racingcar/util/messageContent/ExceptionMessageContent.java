package racingcar.util.messageContent;

public enum ExceptionMessageContent {
    NICKNAME_LENGTH_ERROR("경주할 자동차의 이름은 최대 4글자로 등록 가능합니다."),
    NICKNAME_UNIQUE_ERROR("중복된 자동차 닉네임이 존재합니다."),
    NICKNAME_SPACE_ERROR("공백은 허용하지 않습니다."),
    NOT_INTEGER_ERROR("시도할 회수는 숫자로만 입력 가능합니다.");

    private final String content;

    ExceptionMessageContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
