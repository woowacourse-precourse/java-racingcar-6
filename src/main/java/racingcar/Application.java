package racingcar;

import racingcar.controller.GameInputController;
import racingcar.controller.GameOutputController;

public class Application {

    public static void main(String[] args) {
        GameInputController inputController = new GameInputController();
        GameOutputController outputController = new GameOutputController();
        Client client = new Client();
        client.run(inputController, outputController);
    }
}
