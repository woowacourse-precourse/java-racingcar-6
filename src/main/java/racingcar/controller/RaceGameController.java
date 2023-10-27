package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.util.Console;
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
        return Console.requestNames();
    }

    private int requestAttemptCount(){
        InputView.printAttemptCountMessage();
        return Console.getNumberOfMovementAttempts();
    }

}
