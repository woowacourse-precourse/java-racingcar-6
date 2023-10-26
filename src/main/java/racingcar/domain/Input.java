package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    String userInput;

    public List<String> inputCarNames() {
        userInput = Console.readLine();
        List<String> carNames = new ArrayList<>();
        carNames = Arrays.asList(userInput.split(","));
        validateNameLength(carNames);
        return carNames;
    }

    private void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputGameCount() {
        userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
