package racingcar.controller;

import java.util.List;

import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        RacingGameView view = new RacingGameView();

        List<String> carNames = view.requestCarNames();
        int rounds = view.requestRounds();

        RacingGame racingGame = new RacingGame(carNames, rounds);
        racingGame.start(view);
    }
}
