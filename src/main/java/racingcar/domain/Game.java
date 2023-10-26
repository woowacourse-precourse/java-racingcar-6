package racingcar.domain;

import racingcar.util.StringUtils;
import racingcar.util.io.InputUtils;
import racingcar.util.io.InputValidator;
import racingcar.util.io.OutputUtils;

public class Game {

    private int moveNumber;

    public void start() {
        OutputUtils.printCarInputMessage();
        String carNameString = getCarsInfo();
        OutputUtils.printMoveInputMessage();
        String moveNumberString = getMoveInfo();
        race(carNameString, moveNumberString);
    }

    public void race(String car, String move) {
        OutputUtils.printExecutionResultMessage();
        Cars cars = new Cars(car);
        moveNumber = StringUtils.toInteger(move);

        while (moveNumber > 0) {
            cars.move();
            moveNumber--;
        }

        raceAward(cars);
    }

    public void raceAward(Cars cars) {
        String winners = cars.award();
        OutputUtils.printFinalWinners(winners);
    }

    public String getCarsInfo() {
        String carNames = InputUtils.getCarsName();
        InputValidator.validateCarNameInput(carNames);
        InputValidator.validateCarNameLength(carNames);
        return carNames;
    }

    public String getMoveInfo() {
        String moveNumber = InputUtils.getMoveNumber();
        InputValidator.validateMoveNumberInput(moveNumber);
        return moveNumber;
    }
}
