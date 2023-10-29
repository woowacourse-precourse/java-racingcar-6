package racingcar.Controller;

import java.util.List;

public class InputConverter {
    public static List<String> nameInputCvt(String input){
        List<String> inputs = List.of(input.split(","));
        InputValidator.checkCarNames(inputs);
        return inputs;
    }

    public static int turnsInputCnt(String input) {
        int turns = InputValidator.checkTurn(input);
        return turns;
    }
}
