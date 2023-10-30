package racingcar.controller;

import java.util.List;
import racingcar.controller.subcontroller.InitializeCarController;
import racingcar.controller.subcontroller.MoveCarController;
import racingcar.domain.Car;
import racingcar.domain.repository.CarRepository;
import racingcar.util.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InitializeCarController initializeCarController;
    private final MoveCarController moveCarController;

    public MainController(InputView inputView, OutputView outputView,
                          InitializeCarController initializeCarController,
                          MoveCarController moveCarController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initializeCarController = initializeCarController;
        this.moveCarController = moveCarController;
    }

    public void start() {
        List<String> names = inputToNameCar(); // 자동차 이름 입력
        int tryCount = inputTryToMoveCar(); // 이동을 시도할 횟수 입력
        initializeCar(names, tryCount);
        for (int i = 0; i < tryCount; i++) {
            moveCar();
        }
    }

    private void moveCar() {
        for (Car car : CarRepository.cars()) {
            moveCarController.moveCar(car);
        }
        outputView.outputResult();
        System.out.println();
    }

    private void initializeCar(List<String> names, int tryCount) {
        initializeCarController.initializeCar(names, tryCount);
    }

    private List<String> inputToNameCar() {
        String inputToNameCar = inputView.inputToNameCar();
        List<String> splits = Util.splitNameByComma(inputToNameCar);
        return splits;
    }

    private int inputTryToMoveCar() {
        String inputTryToMoveCar = inputView.inputTryToMoveCar();
        int tryCount = Util.convertStringToInt(inputTryToMoveCar);
        return tryCount;
    }
}
