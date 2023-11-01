package racingcar.controller;

import racingcar.controller.subcontroller.DetermineWinnerController;
import racingcar.controller.subcontroller.InitializeCarController;
import racingcar.controller.subcontroller.MoveCarController;

public class MainController {
    private final InitializeCarController initializeCarController;
    private final MoveCarController moveCarController;
    private final DetermineWinnerController determineWinnerController;

    public MainController(
            InitializeCarController initializeCarController,
            MoveCarController moveCarController,
            DetermineWinnerController determineWinnerController
    ) {
        this.initializeCarController = initializeCarController;
        this.moveCarController = moveCarController;
        this.determineWinnerController = determineWinnerController;
    }

    public void start() {
        initializeCar();         // Car 객체 생성
        moveCar();               // 자동차 이동
        determineWinner();       // 순위 매기기 (우승자 발표)
    }

    private void determineWinner() {
        determineWinnerController.determineWinner();
    }

    private void moveCar() {
        moveCarController.moveCar();
    }

    private void initializeCar() {
        initializeCarController.initializeCar();
    }
}
