package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(Console::readLine));
        gameController.startGame();
    }
}
