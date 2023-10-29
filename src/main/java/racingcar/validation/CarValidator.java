package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {

    public static final String ONLY_HAS_CHARACTER_OR_NUMBER_ERROR = "자동차 이름은 숫자/한글/영어로 구성되어야 합니다.";
    public static final String LENGTH_MIN_ONE_ERROR = "글자수가 1자 이상의 자동차 이름을 입력해야합니다.";
    public static final String LENGTH_MAX_FIVE_ERROR = "글자수가 5자 이하의 자동차 이름을 입력해야합니다.";
    public static final String DUPLICATED_CAR_NAME_ERROR = "중복된 자동차 이름이 존재합니다.";

    private static final Integer MAX_NAME_LENGTH = 5;
    private static final Integer MIN_NAME_LENGTH = 1;
    private static final String ONLY_HAS_CHARACTER_OR_NUMBER = "^[a-zA-Z0-9가-힣]*$";

    public static void validateCarNameList(List<String> carNames) {
        validateNameElementHasCharacterOrNumber(carNames);
        validateNameElementLengthMinOne(carNames);
        validateNameElementLengthMaxFive(carNames);
        duplicatedCarNameInNameListThrowException(carNames);
    }

    public static void validateCarName(String carName) {
        unlessHasCharacterOrNumberThrowException(carName);
        lengthUnderOneThrowException(carName);
        lengthOverFiveThrowException(carName);
    }

    private static void validateNameElementHasCharacterOrNumber(List<String> names) {
        names.forEach(CarValidator::unlessHasCharacterOrNumberThrowException);
    }

    private static void validateNameElementLengthMinOne(List<String> names) {
        names.forEach(CarValidator::lengthUnderOneThrowException);
    }

    private static void validateNameElementLengthMaxFive(List<String> names) {
        names.forEach(CarValidator::lengthOverFiveThrowException);
    }

    private static void duplicatedCarNameInNameListThrowException(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR);
        }
    }

    private static void unlessHasCharacterOrNumberThrowException(String name) {
        if (!name.matches(ONLY_HAS_CHARACTER_OR_NUMBER)) {
            throw new IllegalArgumentException(ONLY_HAS_CHARACTER_OR_NUMBER_ERROR);
        }
    }

    private static void lengthUnderOneThrowException(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_MIN_ONE_ERROR);
        }
    }

    private static void lengthOverFiveThrowException(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_MAX_FIVE_ERROR);
        }
    }

}

