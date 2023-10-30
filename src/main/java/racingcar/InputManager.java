package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class InputManager {

    public List<String> inputCarNames() {
        String input = Console.readLine();
        CarNameValidator.validate(input);
        return List.of(input.split(","));
    }
}
