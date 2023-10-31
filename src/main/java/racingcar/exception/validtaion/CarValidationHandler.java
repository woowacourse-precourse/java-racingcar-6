package racingcar.exception.validtaion;

import java.util.List;
import java.util.Set;
import racingcar.utils.RacingCarStringUtils;

public class CarValidationHandler {
    private static final String ALPHA_NUMERIC_REGEX = "^[a-zA-Z0-9]*$";
    private static final String ALPHA_REGEX = "^[a-zA-Z]*$";
    private static final String NUMERIC_REGEX = "^[0-9]*$";
    public static final String CAR_NAME_LENGTH_RESTRICTION = "자동차 이름은 5글자 이하로 입력해주세요.";
    public static final String PROMPT_CAR_NAME_INPUT_RESTRICTION = "입력하지 않은 자동차 이름이 있습니다.";
    public static final String CAR_NAME_FORMAT_RESTRICTION = "자동차 이름은 영어, 숫자의 조합 또는 영어와 숫자로만 입력해주세요.";
    public static final String CAR_NAME_DUPLICATED_RESTRICTION = "서로 다른 자동차 이름을 입력해주세요.";
    public static final String MIN_CAR_NAMES_REQUIRED_RESTRICTION = "최소 2대 이상의 자동차 이름을 입력해주세요.";

    private CarValidationHandler() {
    }

    public static void validationHasText(String gamCount) {
        if (!RacingCarStringUtils.hasText(gamCount)) {
            throw new IllegalArgumentException(PROMPT_CAR_NAME_INPUT_RESTRICTION);
        }
    }

    public static void validationCarNamesOneSize(List<String> carNameList) {
        if (isOneSize(carNameList)) {
            throw new IllegalArgumentException(MIN_CAR_NAMES_REQUIRED_RESTRICTION);
        }
    }

    public static void validationDuplicatedCarNames(List<String> carNameList, Set<String> carNameSet) {
        if (!isSameSize(carNameList, carNameSet)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED_RESTRICTION);
        }
    }

    public static void validationAlphaNumericOrAlphaOrNumeric(String carName) {
        if (!isAlphaNumericOrAlphaOrNumeric(carName)) {
            throw new IllegalArgumentException(CAR_NAME_FORMAT_RESTRICTION);
        }
    }

    public static void validationCarNameUnder5Length(String carName) {
        if (!isCarNameUnder5Length(carName)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_RESTRICTION);
        }
    }

    private static boolean isCarNameUnder5Length(String carName) {
        return carName.length() <= 5;
    }

    private static boolean isAlphaNumericOrAlphaOrNumeric(String carName) {
        return isAlphaNumeric(carName) || isNumeric(carName) || isAlpha(carName);
    }

    private static boolean isAlphaNumeric(String carName) {
        return carName.matches(ALPHA_NUMERIC_REGEX);
    }

    private static boolean isAlpha(String carName) {
        return carName.matches(ALPHA_REGEX);
    }

    private static boolean isNumeric(String carName) {
        return carName.matches(NUMERIC_REGEX);
    }

    private static boolean isSameSize(List<String> carNameList, Set<String> carNameSet) {
        return carNameList.size() == carNameSet.size();
    }

    private static boolean isOneSize(List<String> carNameList) {
        return carNameList.size() == 1;
    }
}
