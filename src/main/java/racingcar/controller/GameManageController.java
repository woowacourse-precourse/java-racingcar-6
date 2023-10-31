package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameManageService;
import racingcar.verification.InputVerification;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameManageController {

    private final GameManageService gameManageService;

    public GameManageController() {
        gameManageService = new GameManageService();
    }

    private List<Car> inputCar() {
        OutputView.inputNameMessage();
        String cars = InputView.input();
        InputVerification.checkAll(cars);

        return getCars(cars);
    }

    private List<Car> getCars(String cars) {
        List<Car> carList = GameManageService.convertToCarList(cars);
        gameManageService.saveCars(carList);

        return carList;
    }
}
