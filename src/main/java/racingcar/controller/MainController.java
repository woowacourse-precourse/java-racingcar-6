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
        String names = inputView.inputToNameCar();
        List<String> splits = Util.splitNameByComma(names);
        for (String split : splits) {
            initializeCarController.initializeCar(split);
        }
    }
}
