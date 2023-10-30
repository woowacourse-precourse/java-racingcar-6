package racingcar.controller;

import java.util.List;
import racingcar.domain.CarsFactory;
import racingcar.domain.Cars;
import racingcar.dto.RacingGameStatus;
import racingcar.domain.RacingGame;
import racingcar.dto.WinnerNames;
import racingcar.view.View;

public class RacingGameController {
    private final View view;

    public RacingGameController(View view) {
        this.view = view;
    }

    public void play() {
        List<String> carNames = view.getCarNames();
        Cars cars = CarsFactory.createRacingCars(carNames);
        RacingGame racingGame = new RacingGame(cars);

        int raceCount = view.getRaceCount();
        RacingGameStatus racingGameStatus = racingGame.race(raceCount);

        view.showRacingGameStatus(racingGameStatus);
        WinnerNames winnerNames = racingGame.getWinnerNames();
        view.showWinnerNames(winnerNames);
    }
}
