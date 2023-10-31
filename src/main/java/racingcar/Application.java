package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Controller controller = appConfig.controller();
        RacingGame racingGame = controller.initRacingGame();
        controller.play(racingGame.getId());
    }
}
