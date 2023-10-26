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
        return carNames;
    }

    public int inputGameCount() {
        userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
