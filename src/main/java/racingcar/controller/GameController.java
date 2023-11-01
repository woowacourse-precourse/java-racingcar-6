package racingcar.controller;

import java.util.List;
import racingcar.model.Race;
import racingcar.view.GameView;
import racingcar.view.RaceView;

public class GameController {

    private final GameView gameView;
    private final RaceView raceView;

    public GameController() {
        gameView = new GameView();
        raceView = new RaceView();
    }

    public void run() {
        List<String> carNames = gameView.askCarNames();
        Integer numberAttempts = gameView.askNumberAttempts();

        Race race = new Race(carNames);

        for (int i = 0; i < numberAttempts; i++) {
            race.doAttempt();
            raceView.printRace(race);
        }
        raceView.printWinner(race);
    }
}
