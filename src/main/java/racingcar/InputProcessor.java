package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    public static final String CAR_NAMES_INPUT_REGEX = "^[^,]+(,[^,]+)*$";

    public List<Car> getCarNameListInput() {
        String carNamesInput = Console.readLine();
        validateCarNameInput(carNamesInput);
        return parseCarNameInputToList(carNamesInput);
    }

    private static List<Car> parseCarNameInputToList(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");

        return Arrays.stream(carNames)
                .map(Car::of)
                .toList();
    }

    private static void validateCarNameInput(String carNamesInput) {
        if (!carNamesInput.matches(CAR_NAMES_INPUT_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getRepetitionInput() {
        int repetition;

        String repetitionInput = Console.readLine();
        repetition = parseRepititionInput(repetitionInput);
        validateRepititionInput(repetition);

        return repetition;
    }

    private static void validateRepititionInput(int repetition) {
        if (repetition < 1) {
            throw new IllegalArgumentException();
        }
    }

    private static int parseRepititionInput(String repetitionInput) {
        int repetition;
        try {
            repetition = Integer.parseInt(repetitionInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return repetition;
    }
}
