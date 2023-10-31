package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameManageService;
import racingcar.util.verification.InputVerification;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameManageController {

    private final GameManageService gameManageService;

    public GameManageController() {
        gameManageService = new GameManageService();
    }

    public void startGame() {
        List<Car> cars = inputCar();
        int repeatCount = inputCount();

        OutputView.executionResultMessage();
        repeatRace(cars, repeatCount);

        String result = gameManageService.winnerToString();
        OutputView.winner(result);
    }

    private List<Car> inputCar() {
        OutputView.inputNameMessage();
        String cars = InputView.input();
        InputVerification.checkAll(cars);

        return getCars(cars);
    }

    private void repeatRace(List<Car> cars, int repeatCount) {
        for(int i = 0; i < repeatCount; i++) {
            gameManageService.race();
            OutputView.carResult(cars.stream()
                    .map(Car::toDTO)
                    .collect(Collectors.toList())
            );
        }
    }

    private List<Car> getCars(String cars) {
        List<Car> carList = GameManageService.convertToCarList(cars);
        gameManageService.saveCars(carList);

        return carList;
    }

    private static int inputCount() {
        OutputView.inputCountMessage();
        String count = InputView.input();
        InputVerification.checkInputType(count);

        return Integer.parseInt(count);
    }
}
