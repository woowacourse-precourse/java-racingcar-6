package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.GameView;

public class RaceController {
    private final GameView gameView;
    private final RaceService raceService;

    public RaceController() {
        this.gameView = new GameView();
        this.raceService = new RaceService();
    }
}
