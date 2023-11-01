package racingcar;

import racingcar.controller.Game;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Game game = appConfig.game();
        game.start();
    }
}
