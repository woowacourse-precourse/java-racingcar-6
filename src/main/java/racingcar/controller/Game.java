package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        OutputView.printStartMessage();
        List<String> stringCarList = InputView.getRacingCars(); // [abc,def,ge]
        List<Car> racingCarList = new ArrayList<>();
        for (String stringCar : stringCarList) {
            Car car = new Car(stringCar, 0);
            racingCarList.add(car);
        }

        Race race = new Race(racingCarList);
        OutputView.printTryMessage();
        int tryNumber = InputView.getTryNumber(); // 5
        OutputView.printShowResultString();
        for (int i = 0; i < tryNumber; i++) {
            race.run();
            System.out.println();
        }
    }
}