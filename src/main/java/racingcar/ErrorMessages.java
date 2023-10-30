package racingcar;

public enum ErrorMessages {
    NOT_NUMBER("숫자만 입력해주세요."),
    OVER_LENGTH_CARNAME("자 이하의 이름만 입력가능"),
    CONTAIN_WHITE_SPACE("이름에 공백이 포함되어 있습니다."),
    NOT_ENOUGH_CAR_NUMBER("대 이상의 이름을 입력해야 합니다."),
    CONTAIN_DUPLICATE_CARNAME("중복되는 이름이 있습니다."),
    NOT_OVER_ZERO("0보다 큰 수를 입력해주세요");

    private String description;

    ErrorMessages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
