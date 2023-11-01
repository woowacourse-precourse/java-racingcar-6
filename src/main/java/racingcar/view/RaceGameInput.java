package racingcar.view;

import java.util.List;

public record RaceGameInput(List<String> carNames, int round) {

    private static final String DELIMITER = ",";

    public static RaceGameInput from(final String carNamesInput, final String roundInput) {
        validateCarNamesInput(carNamesInput);
        validateRoundInput(roundInput);
        return new RaceGameInput(List.of(carNamesInput.split(DELIMITER)), Integer.parseInt(roundInput));
    }

    private static void validateCarNamesInput(final String carNamesInput) {
        isInputEmpty(carNamesInput);
        startOrEndsWithDelimiter(carNamesInput);
    }

    private static void isInputEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private static void startOrEndsWithDelimiter(final String input) {
        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("입력값은 쉼표로 시작하거나 끝날 수 없습니다.");
        }
    }

    private static void validateRoundInput(final String roundInput) {
        isNumeric(roundInput);
    }

    private static void isNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
