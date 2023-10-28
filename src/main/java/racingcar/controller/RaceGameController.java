package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.util.Console;
import racingcar.service.RaceGameService;
import racingcar.view.GameStartEndView;

import java.util.List;

import static racingcar.util.CarListConverter.*;

public class RaceGameController {

    private GameStartEndView gameStartEndView;
    private final RaceCars raceCars;
    private final int attemptCount;

    public RaceGameController() {
        this.gameStartEndView = new GameStartEndView();
        List<Car> cars = convertStringArrayToCarList(requestCarNames());
        this.attemptCount = requestAttemptCount();
        this.raceCars = new RaceCars(cars);
    }

    private String[] requestCarNames() {
        gameStartEndView.printStartMessage();
        return Console.requestNames();
    }

    private int requestAttemptCount(){
        gameStartEndView.printAttemptCountMessage();
        return Console.getNumberOfMovementAttempts();
    }

    public void start(){
        RaceGameService raceGameService = new RaceGameService(raceCars, attemptCount);
        raceGameService.run();
    }

    public void printWinningCarNames(){
        gameStartEndView.printWinningCarNames(raceCars.getWinningCarNames());
    }

}
