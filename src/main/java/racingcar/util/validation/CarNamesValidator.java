package racingcar.util.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.vo.CarName;

public class CarNamesValidator {

    private static final Integer MIN_CAR_NAME_SIZE = 2;
    private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름에 빈 값은 허용되지 않습니다.";
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "중복된 자동차 이름이 존재합니다.";
    private static final String MIN_CAR_NAME_SIZE_ERROR_MESSAGE = "최소 %s개 이상의 자동차 이름을 입력하셔야 합니다.";

    private CarNamesValidator() {
    }

    public static void validateCarNames(List<CarName> carNames) {
        if (hasEmptyName(carNames)) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR_MESSAGE);
        }
        if (hasDuplicate(carNames)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
        if (isCarNameListSmallerThanMin(carNames)) {
            String errorMessage = String.format(MIN_CAR_NAME_SIZE_ERROR_MESSAGE, MIN_CAR_NAME_SIZE);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isCarNameListSmallerThanMin(List<CarName> carNames) {
        return carNames.size() < MIN_CAR_NAME_SIZE;
    }

    private static boolean hasEmptyName(List<CarName> carNames) {
        for (CarName carName : carNames) {
            if (carName.name().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicate(List<CarName> carNames) {
        Set<CarName> names = new HashSet<>();
        for (CarName carName : carNames) {
            if (names.contains(carName)) {
                return true;
            }
            names.add(carName);
        }
        return false;
    }
}
