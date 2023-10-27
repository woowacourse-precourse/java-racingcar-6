package racingcar.controller;

import racingcar.model.CarRepository;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final InputView inputView;
    private CarRepository carRepository;
    private int repeatCount;

    public RacingGame(List<String> cars, int repeatCount) {
        this.inputView = new InputView();
        carRepository = new CarRepository(cars);
        this.repeatCount = repeatCount;
    }

    public RacingGame() {
        this(new ArrayList<>(), 10);
    }

    public void start() {
        setupGame();
        System.out.println(carRepository + " " + repeatCount);
    }

    public void setupGame() {
        this.carRepository = new CarRepository(inputView.getCarsName());
        this.repeatCount = inputView.getRepeatCount();
    }

}
