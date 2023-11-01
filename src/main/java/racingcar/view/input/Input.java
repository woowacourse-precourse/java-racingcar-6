package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private final Validation validation = new Validation();

    public String[] inputCarNames() {
        String input = input();
        String[] names = input.split(",");
        validation.areAllInFiveLength(names);
        return names;
    }

    public Integer inputTryNumber() {
        String input = input();
        validation.isNumber(input);
        return Integer.valueOf(input);
    }

    private String input() {
        return Console.readLine();
    }
}
