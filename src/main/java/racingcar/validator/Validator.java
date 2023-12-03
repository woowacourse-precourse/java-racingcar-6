package racingcar.validator;

import java.util.List;

public class Validator {

    private static final String HEAD = "[ERROR] ";
    private static final String CAR_NAME_DUPLICATE = HEAD + "자동차의 이름은 중복이 되면 안됩니다.";
    private static final String CAR_NAME_WRONG = HEAD + "자동차의 이름은 1글자 이상 5글자 이하여야합니다.";
    private static final String CARS_SIZE_WRONG = HEAD + "자동차는 2대 이상이여야합니다.";

    private Validator() {

    }


    public static void validateDuplicate(List<String> carsList) {
        if (carsList.stream().distinct().count() != carsList.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE);
        }
    }

    public static void validateName(List<String> carsList) {
        if (carsList.stream().anyMatch(car -> car.length() > 5 || car.isEmpty())) {
            throw new IllegalArgumentException(CAR_NAME_WRONG);
        }
    }

    public static void validateSize(List<String> carsList) {
        if (carsList.size() < 2) {
            throw new IllegalArgumentException(CARS_SIZE_WRONG);
        }
    }
}
