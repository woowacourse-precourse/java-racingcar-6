package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RaceGameService;
import racingcar.service.RaceGameServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceGameController {

    private RaceGameService raceGameService;
    InputView inputView = new InputView();

    public CarRaceGameController() {
        raceGameService = new RaceGameServiceImpl();
    }

    public void gameStart() {
        Car car = new Car();

        List<String> input = inputView.userInputCarName();
        car.initCar(input);

        int count = Integer.parseInt(inputView.userInputGameCount());

        for (int i=0; i<count; i++) {
            raceGameService.carMoveCheckAndGo(car);
            OutputView.outputCarMoveResult(car);
        }
        OutputView.outputWinnerResult(car, raceGameService.findWinner(car));
    }
}
