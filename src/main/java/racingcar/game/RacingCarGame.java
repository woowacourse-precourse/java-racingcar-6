package racingcar.game;

import racingcar.domain.Computer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {

    private final Computer computer;

    public RacingCarGame() {
        computer = new Computer();
    }

    public void start() {
        OutputView.printStartMessage();
        List<String> carsName = InputView.enterCarsName();
        computer.generateCars(carsName);
    }
}
