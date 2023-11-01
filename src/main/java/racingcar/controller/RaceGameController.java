package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.dto.RaceGameInfoDto;
import racingcar.dto.WinnerCarDto;
import racingcar.util.Console;
import racingcar.service.RaceGameService;
import racingcar.view.GameStartEndView;

import java.util.List;

import static racingcar.util.CarFactory.*;

public class RaceGameController {

    private GameStartEndView gameStartEndView;
    private RaceGameService raceGameService;

    public RaceGameController() {
        this.gameStartEndView = new GameStartEndView();
        this.raceGameService = new RaceGameService();
    }

    public RaceGameInfoDto startRaceGame() {
        List<Car> cars = getCars(requestCarNames());
        return new RaceGameInfoDto(new RaceCars(cars), requestAttemptCount());
    }

    private String[] requestCarNames() {
        gameStartEndView.printCarNameMessage();
        return Console.requestNames();
    }

    private int requestAttemptCount() {
        gameStartEndView.printAttemptCountMessage();
        return Console.requestMovementAttemptCount();
    }

    public WinnerCarDto run(RaceGameInfoDto raceGameInfoDto) {
        return raceGameService.run(raceGameInfoDto);
    }

    public void printWinningCarNames(WinnerCarDto winnerCarDTO) {
        gameStartEndView.printWinningCarNames(winnerCarDTO);
    }

}
