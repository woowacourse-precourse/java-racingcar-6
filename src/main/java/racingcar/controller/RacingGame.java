package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.Input;
import racingcar.view.Output;
import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private Game race;

    public RacingGame() {
    }

    public void start() {
        gameReady();
        race.setGame();
    }

    private void gameReady() {
        Output.carNameInputMessage();
        String carNames = Input.carNamesInput();
        Output.attemptInputMessage();
        int attemptCount = Input.attemptCountInput();
        race = new Game(carNames, attemptCount);
    }

    public static void exception(String str) {
        Console.close();
        throw new IllegalArgumentException(str);
    }
}
