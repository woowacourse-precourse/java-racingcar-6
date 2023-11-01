package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.MovingCount;
import racingcar.model.RacingGame;
import racingcar.validator.CarValidator;
import racingcar.validator.InputValidator;
import racingcar.validator.RacingGameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        CarValidator carValidator = new CarValidator();
        RacingGameValidator racingGameValidator = new RacingGameValidator();

        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();

        Car car = new Car(carValidator);
        MovingCount movingCount = new MovingCount();
        RacingGame racingGame = new RacingGame(movingCount, outputView, racingGameValidator);

        GameController gameController = new GameController(inputView, car, racingGame, outputView);
        gameController.play();
    }
}
