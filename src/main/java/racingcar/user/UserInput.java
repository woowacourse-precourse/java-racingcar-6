package racingcar.user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {

    private List<String> cars = new ArrayList<>();
    private int attemptCount = 0;
    private String input() {
        return Console.readLine().trim();
    }

    private List<String> carNames() {
        String input = input();
        cars = Arrays.asList(input.split(","));
        return cars;
    }

    private int attemptCountInput() {
        String input = input();
        attemptCount = Integer.parseInt(input);
        return attemptCount;
    }

}
