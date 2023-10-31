package racingcar;

import racingcar.config.ApplicationContext;
import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationContext context = new ApplicationContext();
        RacingGameController controller = context.racingGameController();
        controller.run();
    }
}
