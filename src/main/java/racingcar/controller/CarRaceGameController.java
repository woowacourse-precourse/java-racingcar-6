package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RaceGameService;
import racingcar.service.RaceGameServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceGameController {

    private final RaceGameService raceGameService;
    InputView inputView = new InputView();

    public CarRaceGameController() {
        raceGameService = new RaceGameServiceImpl();
    }

    public void run() {
        Car car = raceGameService.startGame(inputView.userInputCarName());
        carMoveResult(car, Integer.parseInt(inputView.userInputGameCount()));
        printWinnerResult(raceGameService.findWinners(car, car.findMaxPosition()));
    }

    private void carMoveResult(Car car, int count) {
        for (int i=0; i<count; i++) {
            raceGameService.race(car);
            OutputView.outputCarMoveResult(car.getCarData());
        }
    }

    private void printWinnerResult(List<String> winners) {
        OutputView.outputWinnerResult(winners);
    }
}
