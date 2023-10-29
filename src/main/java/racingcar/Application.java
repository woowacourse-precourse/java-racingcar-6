package racingcar;

import racingcar.controller.GameInputController;
import racingcar.controller.GameOutputController;

public class Application {

    public static void main(String[] args) {
        GameInputController inputController = new GameInputController();
        inputController.settingController();
        inputController.requestNames();
        inputController.requestTryNumber();

        GameOutputController outputController = new GameOutputController();
        outputController.readyForGame(inputController.sendGameInfo());
        outputController.startGame();
    }
}
