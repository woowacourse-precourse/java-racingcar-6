package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    private static final int CAR_NAME_MIN_SIZE = 1;
    private static final int CAR_NAME_MAX_SIZE = 5;
    //private static final String CAR_NAME_REGEX = "^[\\w]*$";
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 1자 이상, 5자 이하여야 합니다.";
    private static final String CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";

    public void validateCarName(List<String> carNameList) {
        if (!validateNameSize(carNameList)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }

        if (!validateNameDuplication(carNameList)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private boolean validateNameSize(List<String> carNameList) {
        return carNameList.stream()
                .allMatch(carName -> CAR_NAME_MIN_SIZE <= carName.length() && carName.length() < CAR_NAME_MAX_SIZE);
    }

    private boolean validateNameDuplication(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        return carNameList.size() == carNameSet.size();
    }
}
