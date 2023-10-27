package racingcar.controller;

import racingcar.entity.car.Car;
import racingcar.entity.car.RaceCars;
import racingcar.request.RequestChecker;
import racingcar.service.RaceGameService;
import racingcar.view.InputView;

import java.util.List;

import static racingcar.util.CarListConverter.*;

public class RaceGameController {

    public void start(){

        List<Car> cars = convertStringArrayToCarList(requestCarNames());
        int attemptCount = requestAttemptCount();

        RaceCars raceCars = new RaceCars(cars);

        RaceGameService raceGameService = new RaceGameService(raceCars, attemptCount);
        raceGameService.run();

        raceCars.printWinningCarNames();

    }

    private String[] requestCarNames() {
        InputView.printStartMessage();
        return RequestChecker.requestNames();
    }

    private int requestAttemptCount(){
        InputView.printAttemptCountMessage();
        return RequestChecker.getNumberOfMovementAttempts();
    }

}
