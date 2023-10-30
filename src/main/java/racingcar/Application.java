package racingcar;

import racingcar.game.Director;
import racingcar.game.Simulator;
import racingcar.game.Rule;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame game = RacingGame.createGame();
        game.start();

    }
}
