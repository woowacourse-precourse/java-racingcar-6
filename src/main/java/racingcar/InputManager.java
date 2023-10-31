package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.MoveNumberValidator;

import java.util.List;


public class InputManager {

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        CarNameValidator.validate(input);
        return List.of(input.split(","));
    }

    public int inputMoveNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String moveNumber = Console.readLine();
        MoveNumberValidator.validate(moveNumber);
        return Integer.parseInt(moveNumber);
    }
}
