package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumber;

public class Round {

    public void play(List<Car> carList) {
        createRandom(carList);
    }

    public void createRandom(List<Car> carList) {
        for (Car car : carList) {
            RandomNumber.make();
            if (RandomNumber.isForward()) {
                car.forward(); // 랜덤 수에 따라 차의 위치를 증가
            }
        }
    }

}
