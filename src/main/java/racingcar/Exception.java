package racingcar;

public class Exception {
    static final String INVALID_CAR_NAME_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5자 이내여야 합니다.";
    static final String INVALID_CAR_NUMBER_MESSAGE = "[ERROR] 자동차 대수는 1대 이상이어야 합니다.";
    static final String INVALID_TRY_NUMBER_CHARACTER_MESSAGE = "[ERROR] 시도 횟수에는 숫자만 입력될 수 있습니다.";
    static final String INVALID_TRY_NUMBER_RANGE_MESSAGE = "[ERROR] 시도 횟수는 0회 이상 2,000,000,000회 이하여야 합니다.";

    static void generateInvalidCarNameLengthException() throws IllegalArgumentException {
        throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);
    }

    static void generateInvalidCarNumberException() throws IllegalArgumentException {
        throw new IllegalArgumentException(INVALID_CAR_NUMBER_MESSAGE);
    }

    static void generateInvalidNumberCharacterException() throws IllegalArgumentException {
        throw new IllegalArgumentException(INVALID_TRY_NUMBER_CHARACTER_MESSAGE);
    }
}
