package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.util.Console;
import racingcar.service.RaceGameService;
import racingcar.view.ExecutionView;
import racingcar.view.GameStartEndView;

import java.util.List;

import static racingcar.util.CarListConverter.*;

public class RaceGameController {

    private GameStartEndView gameStartEndView;

    public RaceGameController(GameStartEndView gameStartEndView) {
        this.gameStartEndView = gameStartEndView;
    }

    public void start(){
        List<Car> cars = convertStringArrayToCarList(requestCarNames());
        int attemptCount = requestAttemptCount();

        RaceCars raceCars = new RaceCars(cars);

        RaceGameService raceGameService = new RaceGameService(raceCars, attemptCount, new ExecutionView());
        raceGameService.run();

        gameStartEndView.printWinningCarNames(raceCars.getWinningCarNames());
    }

    private String[] requestCarNames() {
        gameStartEndView.printStartMessage();
        return Console.requestNames();
    }

    private int requestAttemptCount(){
        gameStartEndView.printAttemptCountMessage();
        return Console.getNumberOfMovementAttempts();
    }

}
