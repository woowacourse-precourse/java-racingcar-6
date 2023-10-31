package racingcar;

public class UserInputValidator {

    private static final String REGEXP_ONLY_NUM = "^[1-9][0-9]*$";

    private static final String SPACE = "\\s";

    private static final Integer ALLOW_CAR_NAME_LENGTH = 5;

    private static final Integer MINIMUM_CAR_COUNT = 2;

    private static final Integer MAX_ATTEMPT_COUNT = 9_999;

    private static final String ERROR_MSG_EMPTY_CAR_NAME = "자동차 이름을 입력해야 합니다.";

    private static final String ERROR_MSG_MINIMUM_CAR_NAME = "자동차 이름은 최소 %s 대이상 입력해야 합니다.";

    private static final String ERROR_MSG_CAR_NAME_LENGTH = "자동차 이름 %s은 허용 길이 %s 글자를 넘었습니다";

    public static boolean carNameIsValid(String carName) {
        checkEmptyCarName(carName);
        String[] carNames = carName.replaceAll(SPACE, "").split(",");
        checkMinimumCarName(carNames);
        for (String name : carNames) {
            checkCarNameLength(name);
        }

        return true;
    }

    public static void checkEmptyCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException(ERROR_MSG_EMPTY_CAR_NAME);
        }
    }

    public static void checkMinimumCarName(String[] carNames) {
        if (carNames.length < MINIMUM_CAR_COUNT || carNames[0].isEmpty()) {
            throw new IllegalArgumentException(String.format(ERROR_MSG_MINIMUM_CAR_NAME, MINIMUM_CAR_COUNT));
        }
    }


    public static boolean attemptCountIsValid(String attempt) {
        if (!attempt.matches(REGEXP_ONLY_NUM)) {
            throw new IllegalArgumentException("횟수는 숫자로만 입력해주세요");
        } else if (!isValidNumberScope(attempt)) {
            throw new IllegalArgumentException(MAX_ATTEMPT_COUNT + "초과 횟수는 입력 불가합니다");
        }

        return true;
    }

    public static void checkCarNameLength(String carName) {
        if (carName.length() > ALLOW_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ERROR_MSG_CAR_NAME_LENGTH, carName, ALLOW_CAR_NAME_LENGTH));
        }
    }

    public static boolean isValidNumberScope(String attempt) {
        try {
            return Integer.parseInt(attempt) <= MAX_ATTEMPT_COUNT;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}