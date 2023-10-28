package racingcar.validator;

public class RoundValidator {

    public static void validateRounds(String input) {
        if (!isContainOnlyPositiveInteger(input)) {
            throw new IllegalArgumentException(("경기 횟수는 1 이상의 양수로만 작성되어야합니다."));
        }
    }

    private static boolean isContainOnlyPositiveInteger(String input) {
        String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
        return input.matches(POSITIVE_INTEGER_REGEX);
    }
}
