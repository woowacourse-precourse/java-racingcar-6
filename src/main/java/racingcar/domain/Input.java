package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;

    String userInput;

    public List<String> getCarNames() {
        userInput = Console.readLine();
        List<String> carNames = Arrays.asList(userInput.split(","));
        validateNameLength(carNames);
        return carNames;
    }

    private void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (!(name.length() <= CAR_NAME_MAX_LENGTH && name.length() >= CAR_NAME_MIN_LENGTH)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getGameCount() {
        userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
