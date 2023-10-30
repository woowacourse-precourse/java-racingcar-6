package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class Controller {
    private final InputView inputView = new InputView();
    //    private final OutputView outputView = new OutputView();
    private final List<Object> carsList = new ArrayList<>();
    private String trial;

    public void run() {
        startGame();
        playGame();
        endGame();
    }

    public void startGame() {
        String[] carsList = inputView.inputCarsName();
        trial = inputView.inputTrial();
        carGenerator(carsList);
    }

    public void playGame() {
        moveCar();
        showRoundResult();
    }

    public void endGame() {
        findWinner();
        showWinner();
    }

    public void carGenerator(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            Car car = new Car();
            car.putName(cars[i]);
            carsList.add(car);
        }
    }

}
