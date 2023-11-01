package racingcar.utils;

public enum ErrorMessage {
    DELIMITER_ERROR("자동차 이름 구분은 ','로 하셔야합니다"),

    NO_NAME_ERROR("레이싱 자동차 이름이 없습니다"),

    ALPHA_NAME_ERROR("레이싱 자동차 이름은 영어만 허용됩니다"),

    NAME_LENGTH_ERROR("자동차 이름 길이는 5이하 입니다"),

    DUPLICATED_NAME_ERROR("중복된 자동차 이름이 있습니다"),

    DIGIT_RACE_COUNT_ERROR("숫자만 입력해주시길 바랍니다"),

    EMPTY_RACE_COUNT_ERROR("레이스 횟수를 입력하시길 바랍니다"),

    ZERO_RACE_COUNT_ERROR("레이스 시도 횟수는 1 이상입니다");
    ;

    private String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    public String getDelimiterError() {
        return DELIMITER_ERROR.error;
    }

    public String getNoCarsNameError() {
        return NO_NAME_ERROR.error;
    }

    public String getAlphaCarNameError() {
        return ALPHA_NAME_ERROR.error;
    }

    public String getCarNameLengthError() {
        return NAME_LENGTH_ERROR.error;
    }

    public String getDuplicatedCarNamesError() {
        return DUPLICATED_NAME_ERROR.error;
    }

    public String getDigitRaceCountError() {
        return DIGIT_RACE_COUNT_ERROR.error;
    }

    public String getEmptyRaceCountError() {
        return EMPTY_RACE_COUNT_ERROR.error;
    }

    public String getZeroRaceCountError() {
        return ZERO_RACE_COUNT_ERROR.error;
    }
}
