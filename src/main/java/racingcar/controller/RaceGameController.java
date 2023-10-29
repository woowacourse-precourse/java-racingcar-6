package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.dto.RaceGameInfoDto;
import racingcar.util.Console;
import racingcar.service.RaceGameService;
import racingcar.view.GameStartEndView;

import java.util.List;

import static racingcar.util.CarListConverter.*;

public class RaceGameController {

    private GameStartEndView gameStartEndView;
    private RaceGameService raceGameService;

    public RaceGameController() {
        this.gameStartEndView = new GameStartEndView();
        this.raceGameService = new RaceGameService();
    }

    public RaceGameInfoDto startRaceGame() {
        List<Car> cars = convertCarNamesToCarList(requestCarNames());
        return new RaceGameInfoDto(new RaceCars(cars), requestAttemptCount());
    }

    private String[] requestCarNames() {
        gameStartEndView.printStartMessage();
        return Console.requestNames();
    }

    private int requestAttemptCount() {
        gameStartEndView.printAttemptCountMessage();
        return Console.getNumberOfMovementAttempts();
    }

    public RaceCars run(RaceGameInfoDto raceGameInfoDto) {
        return raceGameService.run(raceGameInfoDto);
    }

    public void printWinningCarNames(RaceCars raceCars) {
        gameStartEndView.printWinningCarNames(raceCars);
    }

}
