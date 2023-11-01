package racingcar;

import racingcar.controller.GameInputController;
import racingcar.controller.GameOutputController;

public class Client {
    GameInputController gameInputController;
    GameOutputController gameOutputController;

    public void makeFakeClient(GameInputController inputController, GameOutputController outputController) {
        this.gameInputController = inputController;
        this.gameOutputController = outputController;
    }

    public void run(GameInputController inputController, GameOutputController outputController) {
        makeFakeClient(inputController, outputController);
        readyForGame();
        playGame();
    }

    public void readyForGame() {
        gameInputController.settingController();
        gameInputController.requestNames();
        gameInputController.requestTryNumber();
    }

    public void playGame() {
        gameOutputController.readyForGame(gameInputController.sendGameInfo());
        gameOutputController.startGame();
        gameOutputController.printWinner();
    }

}
