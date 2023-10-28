package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.Arrays;

public class GameController {

    InputView inputView = new InputView();
    int count; //시도할 횟수

    public void proceed() {
        init();
    }

    /**
     * 경주에 참여할 자동차를 정리하고 시도할 횟수 지정
     */
    private void init() {
        String carNames = inputView.printCarName();
        carsToList(carNames);
        count = inputView.printTryCount();
    }

    private void carsToList(String carNames) {
        String[] cars = carNames.split(",");
        Arrays.stream(cars).forEach(car -> Car.setCar(car));
    }
}
