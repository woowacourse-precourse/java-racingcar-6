package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.model.InputValidator;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        InputValidator inputValidator = new InputValidator();
        RaceGameController raceGameController = new RaceGameController(view, inputValidator);

        raceGameController.start();
    }
}
