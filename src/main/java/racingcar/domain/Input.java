package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<String> inputCarNames() {
        String userInput = Console.readLine();
        List<String> carNames = new ArrayList<>();
        carNames = Arrays.asList(userInput.split(","));
        return carNames;
    }
}
