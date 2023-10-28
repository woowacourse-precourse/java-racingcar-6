package racingcar.controller;

import racingcar.view.InputView;

public class RacingcarController {
    private static final InputView inputView = InputView.getInstance();
    private String[] cars;

    public void run() {
        start();
    }

    private void start() {
        cars = inputView.getCarNames().split(",");

        for (String car : cars) {
            if(car.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하입니다.");
            }
        }

    }
}
