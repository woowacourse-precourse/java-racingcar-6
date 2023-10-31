package racingcar.user;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {

    private List<String> cars = new ArrayList<>();
    private int attemptCount;

    Validation validation = new Validation();

    private String input() {
        String input = validation.nullStringInput(Console.readLine().trim());
        return input;
    }

    private List<String> carNames() {
        String input = input();
        String[] arr = input.split(",");
        cars = Arrays.asList(arr);
        cars = validation.carNameInputValidation(cars);
        return cars;
    }

    public int attemptCountInput() {
        String input = input();
        attemptCount = Integer.parseInt(input);
        return attemptCount;
    }

}
