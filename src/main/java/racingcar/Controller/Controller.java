package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Domain.ProgressBoard;
import racingcar.Domain.ProgressDto;
import racingcar.Service.Service;
import racingcar.Utils.InputValidator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Controller {
    private final int ZERO = 0;
    private final InputValidator inputValidator;
    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;
    private int tryCount;

    public Controller(Service service) {
        inputValidator = new InputValidator();
        inputView = new InputView();
        outputView = new OutputView();
        this.service = service;
    }

    public void run() {
        initGame();
        startGame();
        endGame();
        cleanGame();
    }

    private void initGame() {
        receiveCarNames();
        receiveTryCount();
    }

    private void receiveTryCount() {
        inputView.printTryCountMessage();
        String inputTryCount = Console.readLine();
        tryCount = inputValidator.validateTryCount(inputTryCount);
    }

    private void receiveCarNames() {
        inputView.printCarNameMessage();
        String inputCars = Console.readLine();
        List<String> cars = inputValidator.validateCarName(inputCars);
        service.registerCars(cars);
    }

    private void startGame() {
        outputView.printResultMessage();
        while (tryCount > ZERO) {
            service.executeOneGame();
            List<ProgressDto> allProgressOfCar = service.getAllProgressOfCar();
            outputView.printProgressMessage(allProgressOfCar);
            tryCount--;
        }
    }

    private void endGame() {
        List<String> winners = service.getWinners();
        outputView.printFinalWinner(winners);
    }

    private void cleanGame() {
        service.cleanProgressBoard();
    }

}
