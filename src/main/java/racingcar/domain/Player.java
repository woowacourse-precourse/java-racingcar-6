package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private static final List<String> carNames = new ArrayList<>();
    private static int raceCount;

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

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
        for (String input : inputs) {
            validateCarNameLength(input);

            carNames.add(input);
        }
    }

    private void validateCarNameLength(String input) {
        if (input.isEmpty() || input.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public void inputRaceCount() {
        String input = Console.readLine();
        validateRaceCount(input);
    }

    private void validateRaceCount(String input) {
        validateRaceCountType(input);
        validateRaceCountValue();
    }

    private void validateRaceCountType(String input) {
        try {
            raceCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRaceCountValue() {
        if (raceCount < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getRaceCount() {
        return raceCount;
    }
}
