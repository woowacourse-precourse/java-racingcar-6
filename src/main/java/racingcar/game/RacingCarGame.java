package racingcar.game;

import racingcar.domain.Racing;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {

    private final Racing racing;

    public RacingCarGame() {
        racing = new Racing();
    }

    public void play() {
        List<String> carsName = InputView.enterCarsName();
        racing.generateCars(carsName);

        int movesNumber = InputView.enterMovesNumber();
        racing.updateMovesNumber(movesNumber);
    }
}
