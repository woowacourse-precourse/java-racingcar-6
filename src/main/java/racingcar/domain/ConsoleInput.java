package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInput implements Input {
    private InputValidator inputValidator;

    public ConsoleInput() {
        this.inputValidator = new InputValidator();
    }

    @Override
    public List<String> getCarNames() {
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);

        return new ArrayList<>(List.of(carNames.split(",")));
    }

    @Override
    public int getMoveCount() {
        String moveCount = Console.readLine();
        inputValidator.validateMoveCount(moveCount);

        return Integer.parseInt(moveCount);
    }
}
