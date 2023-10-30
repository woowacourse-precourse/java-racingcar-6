package racingcar.controller;

import java.util.List;
import racingcar.controller.subcontroller.InitializeCarController;
import racingcar.util.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InitializeCarController initializeCarController;

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
        int count = inputTryToMoveCar();
        for (String name : splits) {
            initializeCarController.initializeCar(name, count);
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
