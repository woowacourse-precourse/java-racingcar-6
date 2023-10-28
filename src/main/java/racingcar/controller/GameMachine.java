package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class GameMachine {

    private final InputView inputView;

    public GameMachine() {
        this.inputView = new InputView();
    }

    public void start() {
        Cars cars = inputView.inputCarName();
        int tryCount = inputView.inputTryCount();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            System.out.println(cars.statusMessage());
            System.out.println();
        }

        System.out.printf("최종 우승자 : %s", cars.winnerCars());
    }

}
