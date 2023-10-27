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
}
