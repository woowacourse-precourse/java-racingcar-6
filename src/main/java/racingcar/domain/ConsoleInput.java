package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {
    private InputValidator inputValidator;

    public ConsoleInput() {
        this.inputValidator = new InputValidator();
    }

    @Override
    public void getCarNames() {
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);
    }

    @Override
    public void getMoveCount() {
        String moveCount = Console.readLine();
        inputValidator.validateMoveCount(moveCount);
    }
}
