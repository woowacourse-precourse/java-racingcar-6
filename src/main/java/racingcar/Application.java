package racingcar;

import racingcar.controller.RacingcarController;

public class Application {
    private static RacingcarController controller = RacingcarController.getInstance();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        controller.run();
    }
}
