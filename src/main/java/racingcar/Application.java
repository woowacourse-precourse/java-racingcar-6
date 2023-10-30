package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.controller.Validation;
import racingcar.model.Cars;
import racingcar.view.RacingcarView;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
    }

    public void startGame() {
        Cars cars = new Cars();
        Validation validation = new Validation();
        RacingcarView racingcarView = new RacingcarView();
        RacingcarController racingcarController = new RacingcarController(cars, validation, racingcarView);
        racingcarController.runGame();
    }


}
