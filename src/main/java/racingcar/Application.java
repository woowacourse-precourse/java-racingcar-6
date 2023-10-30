package racingcar;


import racingcar.controller.GameController;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.play();
    }
}
