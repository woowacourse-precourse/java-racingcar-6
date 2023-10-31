package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    public static final String CAR_NAMES_INPUT_REGEX = "^[^,]+(,[^,]+)*$";

    public List<Player> readCarNamesInput() {
        return manipulateCarNameInput(Console.readLine());
    }

    public List<Player> manipulateCarNameInput(String input) {
        validateCarNameInput(input);

        return parseCarNameInputToList(input);
    }

    private static List<Player> parseCarNameInputToList(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");

        return Arrays.stream(carNames)
                .map(Player::of)
                .toList();
    }

    private static void validateCarNameInput(String carNamesInput) {
        if (!carNamesInput.matches(CAR_NAMES_INPUT_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer readRepetitionInput() {
        return manipulateRepetitionInput(Console.readLine());
    }

    public Integer manipulateRepetitionInput(String input) {
        int repetition = parseRepetitionInput(input);
        validateRepetitionInput(repetition);

        return repetition;
    }

    private static void validateRepetitionInput(int repetition) {
        if (repetition < 1) {
            throw new IllegalArgumentException();
        }
    }

    private static int parseRepetitionInput(String repetitionInput) {
        int repetition;
        try {
            repetition = Integer.parseInt(repetitionInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return repetition;
    }
}
