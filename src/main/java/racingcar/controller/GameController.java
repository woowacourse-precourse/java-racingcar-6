package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final List<Car> cars;

    private GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = new ArrayList<>();
    }

    public static GameController makeGame(InputView inputView, OutputView outputView) {
        return new GameController(inputView, outputView);
    }

    public void playGame() {
        startGame();
        findWinner();
    }

    private void startGame() {
        outputView.printStartGame();
        createCars();
    }

    private void createCars() {
        List<String> carNames = inputView.inputCarNames();

        for (String carName : carNames) {
            cars.add(Car.makeCar(carName));
        }
    }

    public void findWinner() {
    }

}
