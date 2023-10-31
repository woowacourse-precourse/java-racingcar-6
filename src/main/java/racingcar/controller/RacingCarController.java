package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingMachine;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private RacingMachine racingMachine;

    public void run() {
        setting();
        play();
        getWinners();
    }

    private void setting() {
        List<String> carNames = InputView.readCarName();
        List<Car> cars = carNames.stream().map(Car::new).toList();
        int moveCount = InputView.readMoveCount();
        racingMachine = new RacingMachine(cars, moveCount);
    }

    private void play() {
        OutputView.writeResultMessage();
        while(racingMachine.canPlay()) {
            racingMachine.play();
            OutputView.writePlayResult(racingMachine.getCars());
        }
    }

    private void getWinners() {
        List<String> winners = racingMachine.getWinners();
        OutputView.writeWinners(winners);
    }
}
