package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String WRONG_INPUT_CAR_NAME_CHARACTER_MASSAGE = "자동차 이름은 문자로 입력해주세요.";
    public static final String WRONG_INPUT_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 5자 이하로 입력해주세요,";
    public static final String WRONG_INPUT_COMMA_MESSAGE = "자동차 이름은 ','로 구분되게 입력해주세요.";
    public static final String WRONG_INPUT_CAR_NAME_DUPLICATION_MESSAGE = "자동차 이름이 중복되지 않게 입력해주세요.";
    public static final String WRONG_INPUT_TRY_COUNT_CHARACTER_MESSAGE = "시도 횟수는 숫자로 입력해주세요.";
    public static final String WRONG_INPUT_TRY_COUNT_ZERO_MESSAGE = "시도 횟수는 0이 아닌 다른 숫자로 입력해주세요.";

    public static void validateNotInputComma(final String input) {
        if (input.length() > MAX_CAR_NAME_LENGTH) {
            validateContainsComma(input);
        }
    }

    private static void validateContainsComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(WRONG_INPUT_COMMA_MESSAGE);
        }
    }

    public static void validateInputCarNameCharacter(final String input) {
        if (hasCharacterIsNotString(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_CAR_NAME_CHARACTER_MASSAGE);
        }
    }

    private static boolean hasCharacterIsNotString(String input) {
        int count = (int) Arrays.stream(input.split(""))
                .filter(str -> !",".equals(str) && !" ".equals(str))
                .filter(str -> str.charAt(0) < 'A' || str.charAt(0) > 'z')
                .count();

        return count > 0;
    }

    public static void validateInputCarNameLength(final String input) {
        long count = Arrays.stream(input.split(","))
                .filter(str -> str.length() > MAX_CAR_NAME_LENGTH)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException(WRONG_INPUT_CAR_NAME_LENGTH_MESSAGE);
        }
    }

    public static void validateDuplicationCarNames(final String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .toList();

        if (hasDuplicationCarNames(carNames)) {
            throw new IllegalArgumentException(WRONG_INPUT_CAR_NAME_DUPLICATION_MESSAGE);
        }
    }

    private static boolean hasDuplicationCarNames(final List<String> carNames) {
        long count = 0;

        for (String carName : carNames) {
            count = carNames.stream()
                    .filter(name -> name.equals(carName))
                    .count();
        }
        return count > 1;
    }

    public static void validateInputTryCountCharacter(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_INPUT_TRY_COUNT_CHARACTER_MESSAGE);
        }
    }

    public static void validateInputTryCountZero(final String input) {
        if ("0".equals(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_TRY_COUNT_ZERO_MESSAGE);
        }
    }
}
