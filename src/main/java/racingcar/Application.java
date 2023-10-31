package racingcar;

import racingcar.configure.AppConfigure;
import racingcar.controller.Game;

public class Application {
    public static void main(String[] args) {

        AppConfigure appConfigure = new AppConfigure();
        Game game = new Game(
                appConfigure.outputView(),
                appConfigure.inputView(),
                appConfigure.manager());
        game.start();
    }
}
