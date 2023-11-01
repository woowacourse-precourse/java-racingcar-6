package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.MovingCount;
import racingcar.model.RacingGame;
import racingcar.validator.CarValidator;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        CarValidator carValidator = new CarValidator();

        InputView inputView = new InputView(inputValidator);

        Car car = new Car(carValidator);
        MovingCount movingCount = new MovingCount();
        RacingGame racingGame = new RacingGame(movingCount);

        GameController gameController = new GameController(inputView, car, racingGame);
        gameController.play();
    }
}
