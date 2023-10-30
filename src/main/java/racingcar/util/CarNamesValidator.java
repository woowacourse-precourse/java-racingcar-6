package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarNamesValidator extends Validator {

    private static final int CAR_NAME_LIMIT = 5;
    private static final String CAR_NAME_SPLITTER = ",";

    private static List<String> validateSplit(String inputtedCarNames) {
        List<String> resultCarNames = null;
        try {
            String trimmedCarNames = trimInputtedString(inputtedCarNames);
            String[] splitCarNames = trimmedCarNames.split(CAR_NAME_SPLITTER);
            resultCarNames = Arrays.stream(splitCarNames)
                    .filter(CarNamesValidator::validateNotBlank)
                    .map(CarNamesValidator::trimInputtedString)
                    .toList();
            validateNotBlankList(resultCarNames);
        } catch (Exception e) {
            throwIllegalArgumentException("자동차 이름 입력 오류", e);
        }
        return resultCarNames;
    }

    private static void validateNotBlankList(List<String> carNames) {
        if (carNames == null || carNames.size() == 0) {
            throwIllegalArgumentException(Error.BLANK_CAR_NAME_ERROR.getMessage());
        }
    }

    private static boolean validateNotBlank(String carName) {
        if (carName == null || carName.equals("")) {
            throwIllegalArgumentException(Error.BLANK_CAR_NAME_ERROR.getMessage());
        }
        return true;
    }

    private static String trimInputtedString(String inputtedCarNames) {
        return inputtedCarNames.trim();
    }

    private static void validateLessThanLength(String carName) {
        if (carName.length() > CarNamesValidator.CAR_NAME_LIMIT) {
            throwIllegalArgumentException(Error.LONG_CAR_NAME_ERROR.getMessage());
        }
    }

    public static List<String> getValidatedCarNamesList(String inputtedString) {
        List<String> carNames = validateSplit(inputtedString);
        for (String carName : carNames) {
            validateLessThanLength(carName);
        }
        return carNames;
    }
}
