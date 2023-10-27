package racingcar.controller;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final InputView inputView;
    private List<String> cars;
    private int repeatCount;

    public RacingGame(List<String> cars, int repeatCount) {
        this.inputView = new InputView();
        this.cars = cars;
        this.repeatCount = repeatCount;
    }

    public RacingGame() {
        this(new ArrayList<>(), 10);
    }

    public void start() {
        setupGame();
        System.out.println(cars + " " + repeatCount);
    }

    public void setupGame() {
        this.cars = inputView.getCarsName();
        this.repeatCount = inputView.getRepeatCount();
    }

}
