package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.MoveNumberValidator;

import java.util.List;


public class InputManager {

    public List<String> inputCarNames() {
        String input = Console.readLine();
        CarNameValidator.validate(input);
        return List.of(input.split(","));
    }

    public int inputMoveNumber() {
        String moveNumber = Console.readLine();
        MoveNumberValidator.validate(moveNumber);
        return Integer.parseInt(moveNumber);
    }
}
