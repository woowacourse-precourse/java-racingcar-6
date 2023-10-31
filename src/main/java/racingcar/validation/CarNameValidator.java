package racingcar.validation;

import static racingcar.constant.NumberConstant.CAR_NAME_MAX_SIZE;
import static racingcar.constant.NumberConstant.CAR_NAME_MIN_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.constant.ExceptionMessage;

public class CarNameValidator {

    private static final Pattern CAR_NAME_TYPE_REGEX = Pattern.compile("^[0-9a-zA-Zㄱ-ㅎ가-힣]*$");

    public static void validateCarName(List<String> carNameList) {
        if (!validateNameSize(carNameList)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH.getMessage());
        }

        if (!validateNameDuplication(carNameList)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATION.getMessage());
        }

        if (validateNameType(carNameList) == false) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_TYPE.getMessage());
        }
    }

    private static boolean validateNameSize(List<String> carNameList) {
        return carNameList.stream()
                .allMatch(carName -> CAR_NAME_MIN_SIZE.getMessage() <= carName.length()
                        && carName.length() < CAR_NAME_MAX_SIZE.getMessage());
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
