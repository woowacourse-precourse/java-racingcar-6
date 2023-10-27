package racingcar;

import racingcar.Car.Car;
import racingcar.View.InputView;
import java.util.List;

public class Race {
    private List< Car > cars;

    public void init() {
        cars = InputView.promptCarNames();
    }

    public void play() {
        System.out.println("생성된 자동차 이름:");
        for (Car car : cars) {
            System.out.println(car.getName());
        }
    }

}
