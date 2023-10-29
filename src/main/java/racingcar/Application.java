package racingcar;

import racingcar.controller.GameInputController;

public class Application {

    public static void main(String[] args) {
        GameInputController controller = new GameInputController();
        controller.settingController();
        controller.requestNames();
        controller.requestTryNumber();

//        // 게임을 진행시킨다.
//        game.running();
    }
}
