package racingcar.Controller;

import java.util.List;
import racingcar.Service.Service;
import racingcar.Utils.InputValidator;

public class Controller {
    private final InputValidator inputValidator;
    private final Service service;
    private int tryCount;

    public Controller() {
        inputValidator = new InputValidator();
        service = new Service();
    }

    public void run() {
        initGame();
        startGame();
        endGame();
    }

    private void initGame() {
        String inputCars = service.receiveCars();
        List<String> cars = inputValidator.validateCarName(inputCars);
        service.registerCars(cars);

        String inputTryCount = service.receiveTrialCount();
        tryCount = inputValidator.validateTryCount(inputTryCount);
    }

    private void startGame() {
        service.printResultMessage();
        while (tryCount > 0) {
            service.executeOneGame();
            service.showProgress();
            tryCount--;
        }
    }

    private void endGame() {
        service.showFinalWinner();
    }

}
