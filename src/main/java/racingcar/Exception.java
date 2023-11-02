package racingcar;

public class Exception {
    static final String GENERAL_INPUT_ERROR = "[ERROR] 올바른 입력이 아닙니다.";
    static final String INVALID_CAR_NAME_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5자 이내여야 합니다.";
    static final String INVALID_CAR_NUMBER_MESSAGE = "[ERROR] 자동차 대수는 1대 이상이어야 합니다.";
    static final String INVALID_TRY_NUMBER_CHARACTER_MESSAGE = "[ERROR] 시도 횟수에는 숫자만 입력될 수 있습니다.";
    static final String INVALID_TRY_NUMBER_RANGE_MESSAGE = "[ERROR] 시도 횟수는 1회 이상 100회 이하여야 합니다.";
    static final String INVALID_DUPLICATE_CAR_NAME_RANGE_MESSAGE = "[ERROR] 자동차 이름은 중복되지 않아야 합니다.";
    static final String OUT_OF_MEMORY_ERROR_MESSAGE = "[ERROR] 메모리가 부족합니다. 입력 길이를 줄이거나 자동차 수를 줄여주세요.";

    static void generateGeneralInputError() throws IllegalArgumentException {
        throw new IllegalArgumentException(GENERAL_INPUT_ERROR);
    }
    static void generateInvalidCarNameLengthException() throws IllegalArgumentException {
        throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);
    }

    static void generateInvalidCarNumberException() throws IllegalArgumentException {
        throw new IllegalArgumentException(INVALID_CAR_NUMBER_MESSAGE);
    }

    static void generateInvalidNumberCharacterException() throws IllegalArgumentException {
        throw new IllegalArgumentException(INVALID_TRY_NUMBER_CHARACTER_MESSAGE);
    }

    static void generateInvalidTryNumberRangeException() throws IllegalArgumentException {
        throw new IllegalArgumentException(INVALID_TRY_NUMBER_RANGE_MESSAGE);
    }

    static void generateInvalidDuplicateCarNameException() throws IllegalArgumentException {
        throw new IllegalArgumentException((INVALID_DUPLICATE_CAR_NAME_RANGE_MESSAGE));
    }

    static void generateOutOfMemoryError() throws IllegalArgumentException {
        throw new IllegalArgumentException(OUT_OF_MEMORY_ERROR_MESSAGE);
    }

}
