package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CarNameValidator {

    private static final int CAR_NAME_MIN_SIZE = 1;
    private static final int CAR_NAME_MAX_SIZE = 5;
    private static final Pattern CAR_NAME_TYPE_REGEX = Pattern.compile("^[0-9a-zA-Zㄱ-ㅎ가-힣]*$");
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 1자 이상, 5자 이하여야 합니다.";
    private static final String CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";
    private static final String CAR_NAME_TYPE_EXCEPTION_MESSAGE = "자동차의 이름은 특수문자를 제외한 문자와 숫자만 허용합니다.";

    public static void validateCarName(List<String> carNameList) {
        if (!validateNameSize(carNameList)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }

        if (!validateNameDuplication(carNameList)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }

        if (validateNameType(carNameList) == false) {
            throw new IllegalArgumentException(CAR_NAME_TYPE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean validateNameSize(List<String> carNameList) {
        return carNameList.stream()
                .allMatch(carName -> CAR_NAME_MIN_SIZE <= carName.length() && carName.length() < CAR_NAME_MAX_SIZE);
    }

    private static boolean validateNameDuplication(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        return carNameList.size() == carNameSet.size();
    }

    private static boolean validateNameType(List<String> carNameList) {
        for (String carName : carNameList) {
            if (!CAR_NAME_TYPE_REGEX.matcher(carName).matches()) {
                return false;
            }
        }
        return true;
    }
}
