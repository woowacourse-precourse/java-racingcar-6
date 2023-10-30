package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    public UserInput() {
    }
    public String input() {
        String input = Console.readLine();
        return input;
    }
    public List<String> carName(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(names));
        return carNames;
    }
    public int attemptCount(String input) {
        int attemptCount;
        attemptCount = Integer.parseInt(input);
        return attemptCount;
    }
    public void processException() {
    }
}