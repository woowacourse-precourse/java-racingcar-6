package racingcar;

import racingcar.controller.GameController;
import racingcar.view.output.ConsoleAskView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController controller = new GameController(
                new ConsoleAskView()
        );

        controller.play();
    }
}
