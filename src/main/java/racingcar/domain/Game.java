package racingcar.domain;

import java.util.List;
import racingcar.util.StringUtils;
import racingcar.util.io.InputUtils;
import racingcar.util.io.OutputUtils;

public class Game {

    private int moveNumber;

    public void start() {
        OutputUtils.printCarInputMessage();
        List<String> carNameList = getCarsInfo();
        OutputUtils.printMoveInputMessage();
        String moveNumberString = getMoveInfo();
        race(carNameList, moveNumberString);
    }

    public void race(List<String> names, String move) {
        OutputUtils.printExecutionResultMessage();
        Cars cars = new Cars(names);
        moveNumber = StringUtils.toInteger(move);

        while (moveNumber > 0) {
            cars.move();
            moveNumber--;
        }

        raceAward(cars);
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void raceAward(Cars cars) {
        String winners = cars.award();
        OutputUtils.printFinalWinners(winners);
    }

    public List<String> getCarsInfo() {
        String carNames = InputUtils.getCarsName();
        InputUtils.validateCarNameInput(carNames);
        return StringUtils.toCarNameList(carNames);
    }

    public String getMoveInfo() {
        String moveNumber = InputUtils.getMoveNumber();
        InputUtils.validateMoveNumberInput(moveNumber);
        return moveNumber;
    }
}
