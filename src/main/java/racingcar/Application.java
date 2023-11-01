package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.run();
        } finally {
            Console.close();
        }
    }
}
