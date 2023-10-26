package racingcar.domain.message;

public enum ErrorMessage {
    INPUT_NULL_BLANK_MESSAGE("입력 값이 존재하지 않습니다.")
    , INPUT_NAME_NULL_BLANK_MESSAGE("입력하신 자동차 이름 중 존재하지 않는 이름이 있습니다.")
    , INPUT_NAME_LENGTH_MESSAGE("자동차 이름 중 %s글자를 초과한 이름이 존재합니다.")
    , INPUT_NAME_DUPLICATE_MESSAGE("중복된 자동차 이름은 입력할 수 없습니다.")
    , INPUT_TRY_TYPE_MESSAGE("시도 횟수는 숫자만 입력 가능합니다.")
    , INPUT_TRY_ZERO_MESSAGE("시도 횟수는 1회 이상 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return this.message;
    }
}