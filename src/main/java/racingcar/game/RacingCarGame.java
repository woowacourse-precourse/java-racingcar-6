package racingcar.game;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {

    private static final int MINIMUM_MOVES_NUMBER = 1;

    private final Racing racing;

    public RacingCarGame() {
        racing = new Racing();
    }

    public void play() {
        initializeCars();
        runRace();
        selectWinner();
    }

    private void initializeCars() {
        List<String> carsName = InputView.enterCarsName();
        racing.generateCars(carsName);
    }

    private void runRace() {
        int movesNumber = InputView.enterMovesNumber();
        validateMovesNumber(movesNumber);

        OutputView.printResultMessage();
        for (int i = 1; i <= movesNumber; i++) {
            racing.runRace();
            List<Car> cars = racing.getCars();
            OutputView.printRaceResult(cars);
        }
    }

    private void selectWinner() {
        List<Car> winingCars = racing.getWiningCars();
        OutputView.printWiningResult(winingCars);
    }

    private void validateMovesNumber(int movesNumber) {
        if (movesNumber < MINIMUM_MOVES_NUMBER) {
            throw new IllegalArgumentException("이동 횟수는 1회 이상이어야 합니다.");
        }
    }
}
