package racingcar.view;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputViewValidator {

    private static final String ERROR_PREFIX_MESSAGE = "[ERROR] : ";
    private static final String ERROR_CAR_NAME_EMPTY_MESSAGE = "차 이름이 공백일 수 없습니다";
    private static final String ERROR_CAR_NAME_LENGTH_MESSAGE = "차 이름은 길이가 5이하여야 합니다";
    private static final String ERROR_DUPLICATE_CAR_NAME_MESSAGE = "차 이름은 중복될 수 없습니다";
    private static final String ERROR_TRY_NUMBER_EMPTY_MESSAGE = "시도 횟수가 공백일 수 없습니다";
    private static final String ERROR_TRY_NUMBER_NOT_INTEGER_MESSAGE = "시도 횟수는 정수 타입이어야 합니다.";
    private static final String ERROR_TRY_NUMBER_NOT_CORRECT_RANGE_MESSAGE = "시도 횟수는 1 이상이어야 합니다.";
    private static final String EMPTY_STRING = "";
    private static final String CAR_NAME_SPLIT_REGEX = ",";
    private static final String INTEGER_REGEX = "-?\\d+";
    private static final int MIN_ADVANCE_COUNT = 4;
    private static final int ZERO_VALUE = 0;
    private static final InputViewValidator INSTANCE = new InputViewValidator();

    private InputViewValidator() {
    }

    public static InputViewValidator getInstance() {
        return INSTANCE;
    }

    public void validateCarNames(String carNames) {

        if (isCarNameEmpty(carNames)) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_CAR_NAME_EMPTY_MESSAGE);
        }
        if (isCarNameCorrectLength(carNames)) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_CAR_NAME_LENGTH_MESSAGE);
        }
        if (isDuplicateCarName(carNames)) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_DUPLICATE_CAR_NAME_MESSAGE);
        }
        if (isEachCarNameEmpty(carNames)) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_CAR_NAME_EMPTY_MESSAGE);
        }
    }

    public void validateTryNumber(String tryNumber) {

        if (isTryNumberEmpty(tryNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_TRY_NUMBER_EMPTY_MESSAGE);
        }
        if (isNotIntegerType(tryNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_TRY_NUMBER_NOT_INTEGER_MESSAGE);
        }
        if (isNotCorrectRange(tryNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + ERROR_TRY_NUMBER_NOT_CORRECT_RANGE_MESSAGE);
        }
    }

    public boolean isNotCorrectRange(String tryNumber) {
        return Integer.parseInt(tryNumber) <= ZERO_VALUE;
    }

    public boolean isNotIntegerType(String tryNumber) {
        return !tryNumber.matches(INTEGER_REGEX);
    }

    public boolean isTryNumberEmpty(String tryNumber) {
        return tryNumber.equals(EMPTY_STRING);
    }

    public boolean isEachCarNameEmpty(String carNames) {
        String[] carNameList = carNames.split(CAR_NAME_SPLIT_REGEX);
        for (String carName : carNameList) {
            if (carName.equals(EMPTY_STRING)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicateCarName(String carNames) {
        String[] carNameList = carNames.split(CAR_NAME_SPLIT_REGEX);

        Set<String> carNameSet = Arrays.stream(carNameList)
                .collect(Collectors.toSet());

        return carNameList.length != carNameSet.size();
    }

    public boolean isCarNameCorrectLength(String carNames) {
        String[] carNameList = carNames.split(CAR_NAME_SPLIT_REGEX);

        for (String carName : carNameList) {
            if (carName.length() >= MIN_ADVANCE_COUNT) {
                return true;
            }
        }
        return false;
    }

    public boolean isCarNameEmpty(String carNames) {
        return carNames.equals(CAR_NAME_SPLIT_REGEX);
    }

}
