package racingcar.enums;

public enum ErrorMessage {
    NULL_ERROR("아무런 값을 입력하지 않았습니다."),
    ONLY_COMMA("자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다."),
    NAME_BETWEEN_ONE_AND_FIVE("자동차 이름은 1 ~ 5글자로 입력해야 합니다."),
    NOT_ALLOW_NAME_REPLACED_BLANK("자동차 이름을 공백으로 입력해선 안됩니다."),
    NOT_ALLOW_BLANK_IN_START("이름의 첫 글자를 공백으로 사용할 수 없습니다."),
    NOT_ALLOW_BLANK_IN_END("이름의 마지막 글자를 공백으로 사용할 수 없습니다."),
    NOT_ALLOW_NAME_DUPLICATION("중복된 이름을 입력할 수 없습니다."),
    TRY_COUNT_ONY_NUMBER("횟수는 숫자만 입력할 수 있습니다."),
    TRY_COUNT_GT_ZERO("게임 시도 횟수는 0보다 커야 합니다."),
    TRY_COUNT_NOT_ALLOW_ZERO_IN_FIRST("게임 시도 횟수의 첫 번째 숫자는 0이 될 수 없습니다."),
    CAR_NAME_COND("이름은 영대소문자,한글,숫자만 입력 가능하고 이름 가운데 공백은 허용됩니다."),
    PARTICIPATION_CAR_COUNT("경주에 참가하는 자동차는 최소 2대 이상이어야 합니다."),
    NOT_ALLOW_END_WITH_COMMA("마지막을 쉼표(,)로 끝낼 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}