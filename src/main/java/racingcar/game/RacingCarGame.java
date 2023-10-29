package racingcar.game;

import racingcar.domain.Computer;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {

    private static final int MINIMUM_MOVES_NUMBER = 1;

    private final Computer computer;

    public RacingCarGame() {
        computer = new Computer();
    }

    public void play() {
        List<String> carsName = InputView.enterCarsName();
        computer.generateCars(carsName);

        int movesNumber = InputView.enterMovesNumber();
        validateMovesNumber(movesNumber);
    }

    private void validateMovesNumber(int movesNumber) {
        if (movesNumber < MINIMUM_MOVES_NUMBER) {
            throw new IllegalArgumentException("이동 횟수는 1회 이상이어야 합니다.");
        }
    }
}
