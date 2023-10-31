package racingcar.util;

public enum ErrorMessage {
    OVER_LENGTH_ERROR("차 이름은 5자 이하로 해주세요."),
    NOT_COMMA_ERROR("이름은 쉽표(,)로 구분해주세요."),
    TRY_NUM_NOT_NUMBER_ERROR("이동 횟수는 숫자를 입력해주세요"),
    EMPTY_INPUT_ERROR("공백을 입력하지 마세요."),
    CAR_NUM_ERROR("차는 두대 이상 입력해주세요."),
    TRY_NUM_IS_ZERO_ERROR("이동 횟수는 1이상으로 입력해주세요."),
    DUPLE_CAR_NAME_ERROR("차 이름이 중복되었습니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
