package racingcar;

import racingcar.model.Game;
import racingcar.controller.RacingGame;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.startGame();
    }
}
