package racingcar;

import racingcar.manager.GameManager;
import racingcar.manager.IOManager;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        IOManager ioManager = new IOManager(new Input(), new Output());
        GameManager gameManager = new GameManager(ioManager);

        gameManager.playRacingGame();
    }
}
