package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
