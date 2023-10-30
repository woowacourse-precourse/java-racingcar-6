package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private static final List<String> carNames = new ArrayList<>();

    private static final int CAR_COUNT = 3;
    private static final int CAR_NAME_LENGTH = 5;

    public void inputCarNames() {
        String input = Console.readLine();
        List<String> inputs = splitInputCarNames(input);
        validateCarNames(inputs);
    }

    private List<String> splitInputCarNames(String input) {
        String[] inputs = input.split(",");
        return Arrays.asList(inputs);
    }

    private void validateCarNames(List<String> inputs) {
        validateCarNamesCount(inputs);
        for (String input : inputs) {
            validateCarNameLength(input);

            carNames.add(input);
        }
    }

    private void validateCarNamesCount(List<String> inputs) {
        if (inputs.size() != CAR_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameLength(String input) {
        if (input.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
