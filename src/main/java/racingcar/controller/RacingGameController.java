package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.dto.RacingGameResult;
import racingcar.domain.RacingGame;
import racingcar.dto.WinnerNames;
import racingcar.view.View;

public class RacingGameController {
    private final View view;

    public RacingGameController(View view) {
        this.view = view;
    }

    public void play() {
        List<String> carNames = view.insertCarNames();
        Cars cars = Cars.createCarsUsingCarNames(carNames);
        RacingGame racingGame = new RacingGame(cars);

        int raceCount = view.insertRaceCount();
        RacingGameResult raceGameResult = racingGame.race(raceCount);

        view.showRacingGameResult(raceGameResult);
    }
}
