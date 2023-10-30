package racingcar.controller;

import java.util.List;
import racingcar.controller.subcontroller.InitializeCarController;
import racingcar.controller.subcontroller.MoveCarController;
import racingcar.util.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InitializeCarController initializeCarController;
    private final MoveCarController moveCarController;

    public MainController(InputView inputView, OutputView outputView, InitializeCarController initializeCarController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initializeCarController = initializeCarController;
    }

    public void start() {
        while (true) {
            initializeCar();
        }
    }

    private void initializeCar() {
        List<String> splits = inputToNameCar();
        int tryCount = inputTryToMoveCar();
        for (String name : splits) {
            initializeCarController.initializeCar(name, tryCount);
        }
    }

    private List<String> inputToNameCar() {
        String inputToNameCar = inputView.inputToNameCar();
        List<String> splits = Util.splitNameByComma(inputToNameCar);
        return splits;
    }

    private int inputTryToMoveCar() {
        String inputTryToMoveCar = inputView.inputTryToMoveCar();
        int count = Util.convertStringToInt(inputTryToMoveCar);
        return count;
    }
}
