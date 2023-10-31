package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class CarValidator {

    public static final String ONLY_HAS_CHARACTER_OR_NUMBER_ALLOWED = "자동차 이름은 숫자/한글/영어로 구성되어야 합니다.";
    public static final String LENGTH_MIN_ONE_ALLOWED = "글자수가 1자 이상의 자동차 이름을 입력해야합니다.";
    public static final String LENGTH_MAX_FIVE_ALLOWED = "글자수가 5자 이하의 자동차 이름을 입력해야합니다.";
    public static final String DUPLICATED_CAR_NAME_NOT_ALLOWED = "중복된 자동차 이름이 존재합니다.";
    public static final String MORE_THAN_TWO_CARS_ALLOWED = "차 2대 이상부터 경주가 가능합니다.";

    private static final Integer MAX_NAME_LENGTH = 5;
    private static final Integer MIN_NAME_LENGTH = 1;
    private static final Integer MIN_CAR_PLAYER_NUMBER = 2;
    private static final String COMPOSE_OF_LETTER_OR_NUMBER_ONLY = "^[a-zA-Z0-9가-힣]*$";

    public static void validateCarNameList(List<String> carNames) {
        duplicatedCarNameThrowException(carNames);
    }

    public static void validateCarListSize(List<Car> cars) {
        if (cars.size() < MIN_CAR_PLAYER_NUMBER) {
            throw new IllegalArgumentException(MORE_THAN_TWO_CARS_ALLOWED);
        }
    }

    public static void validateCarName(String carName) {
        notComposeOfLetterOrNumberOnlyThrowException(carName);
        lengthUnderOneThrowException(carName);
        lengthOverFiveThrowException(carName);
    }

    private static void duplicatedCarNameThrowException(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME_NOT_ALLOWED);
        }
    }

    private static void notComposeOfLetterOrNumberOnlyThrowException(String name) {
        if (!name.matches(COMPOSE_OF_LETTER_OR_NUMBER_ONLY)) {
            throw new IllegalArgumentException(ONLY_HAS_CHARACTER_OR_NUMBER_ALLOWED);
        }
    }

    private static void lengthUnderOneThrowException(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_MIN_ONE_ALLOWED);
        }
    }

    private static void lengthOverFiveThrowException(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_MAX_FIVE_ALLOWED);
        }
    }

}

