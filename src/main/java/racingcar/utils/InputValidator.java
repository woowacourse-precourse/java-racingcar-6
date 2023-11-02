package racingcar.utils;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String INVALID_CAR_LENGTH = "5자 이하의 자동차 이름을 입력해주세요";
    private static final String INVALID_SEPARATOR = "쉼표로 구분해 입력해주세요";
    private static final String DUPLICATE_NAME_EXIST = "중복된 이름이 존재합니다";
    private static final String NAME_NOT_EXIST = "자동차 이름을 입력해주세요";
    private static final String NOT_INTEGER = "0 이상의 숫자를 입력해주세요";

    private static final Pattern NOT_INTEGER_REG_EXP = Pattern.compile("^[1-9][\\d]*$");
    private static final Pattern REMAIN_SEPARATOR_REG_EXP = Pattern.compile("[\\s\\w\\dㄱ-ㅎㅏ-ㅣ가-힣]");
    private static final Pattern CAR_NAMES_INPUT_REG_EXP = Pattern.compile("([\\w\\dㄱ-ㅎㅏ-ㅣ가-힣]*,)*");

    private static final int MAX_LENGTH = 5;

    public static void checkCarNames(List<String> carNames, String carInput) {
        checkSeparator(carInput);
        checkNameLength(carNames);
        checkNameIsDuplicated(carNames);
        checkNameIsExist(carNames);
    }

    public static void checkNameLength(List<String> carNames) {
        if (!carNames.stream().allMatch(carName -> carName.length() <= MAX_LENGTH)) {
            throw new IllegalArgumentException(INVALID_CAR_LENGTH);
        }
    }

    public static void checkSeparator(String carInput) {
        String carNames = CAR_NAMES_INPUT_REG_EXP.matcher(carInput).replaceAll("");
        String remainSeparator = REMAIN_SEPARATOR_REG_EXP.matcher(carNames).replaceAll("");

        if (!remainSeparator.isEmpty()) {
            throw new IllegalArgumentException(INVALID_SEPARATOR);
        }
    }

    public static void checkNameIsDuplicated(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_EXIST);
        }
    }

    public static void checkNameIsExist(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException(NAME_NOT_EXIST);
            }
        }
    }

    public static void checkTryNumberIsInteger(String tryNumber) {
        if (!NOT_INTEGER_REG_EXP.matcher(tryNumber).matches()) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

}
