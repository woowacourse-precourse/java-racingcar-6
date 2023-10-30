package racingcar.controller;

import java.util.List;
import racingcar.domain.CarFactory;
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
        Cars cars = CarFactory.createRacingCars(carNames);
        RacingGame racingGame = new RacingGame(cars);

        int racingCount = view.getRacingCount();
        RacingGameStatus racingGameStatus = racingGame.race(racingCount);

        view.showRacingGameStatus(racingGameStatus);
        WinnerNames winnerNames = racingGame.getWinnerNames();
        view.showWinnerNames(winnerNames);
    }
}
