package racingcar.controller;

import racingcar.entity.car.Car;
import racingcar.entity.car.RaceCars;
import racingcar.request.RequestChecker;
import racingcar.service.RaceGameService;
import racingcar.util.CarListConverter;
import racingcar.view.InputView;

import java.util.List;

import static racingcar.util.CarListConverter.*;

public class RaceGameController {

    public void start(){
        InputView.printStartMessage();
        List<Car> cars = convertStringArrayToCarList(RequestChecker.requestNames());
        InputView.printAttemptCountMessage();
        int attemptCount = RequestChecker.getNumberOfMovementAttempts();

        RaceGameService raceGameService = new RaceGameService(new RaceCars(cars), attemptCount);
        raceGameService.run();

    }

    public static void main(String[] args) {
        RaceGameController raceGameController = new RaceGameController();
        raceGameController.start();
    }
}
