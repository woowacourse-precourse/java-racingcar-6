package racingcar.domain;

import java.util.List;
import racingcar.util.io.InputUtils;
import racingcar.util.io.InputValidator;
import racingcar.util.io.OutputUtils;

public class Game {

    private List<Car> carList;
    public void start() {
        OutputUtils.printCarInputMessage();
        getCarsInfo();
        OutputUtils.printMoveInputMessage();
        getMoveInfo();
    }

    public void getCarsInfo() {
        String carNames = InputUtils.getCarsName();
        InputValidator.validateCarNameInput(carNames);
        InputValidator.validateCarNameLength(carNames);
    }

    public void getMoveInfo() {
        String moveNumber = InputUtils.getMoveNumber();
        InputValidator.validateMoveNumberInput(moveNumber);
    }
}
