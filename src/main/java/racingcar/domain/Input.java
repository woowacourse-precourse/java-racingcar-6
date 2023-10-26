package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String COMMA = ",";

    String userInput;

    public List<String> getCarNames() {
        userInput = Console.readLine();
        List<String> carNames = Arrays.asList(userInput.split(COMMA));
        validateNameLength(carNames);
        return carNames;
    }

    private void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getGameCount() {
        userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
