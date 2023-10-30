package racingcar;

import racingcar.view.InputView;

public class GameController {

    private static GameController gameController = new GameController();
    private InputView inputView = InputView.getInstance();

    private GameController() {
    }

    public static GameController getInstance() {
        return gameController;
    }

    public void startGame() {
        Cars cars = new Cars();
        String carsNames = inputView.carsInput();
        cars.addCar(carsNames);

    }
}
