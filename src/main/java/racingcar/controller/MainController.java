package racingcar.controller;

import java.util.List;
import racingcar.controller.subcontroller.DetermineWinnerController;
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
    private final DetermineWinnerController determineWinnerController;

    public MainController(InputView inputView, OutputView outputView,
                          InitializeCarController initializeCarController,
                          MoveCarController moveCarController,
                          DetermineWinnerController determineWinnerController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initializeCarController = initializeCarController;
        this.moveCarController = moveCarController;
        this.determineWinnerController = determineWinnerController;
    }

    public void start() {
        List<String> names = inputToNameCar();  // 자동차 이름 입력
        int tryCount = inputTryToMoveCar();     // 이동을 시도할 횟수 입력
        initializeCar(names, tryCount);         // Car 객체 생성
        for (int i = 0; i < tryCount; i++) {
            moveCar();                          // 자동차 이동
        }
        determineWinner();                      // 순위 매기기 (우승자 발표)
    }

    private void determineWinner() {
        List<String> winners = determineWinnerController.determineWinner();
        outputView.outputWinner(winners);
    }

    private void moveCar() {
        for (Car car : CarRepository.cars()) {
            moveCarController.moveCar(car);
        }
        outputView.outputMoving();
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
