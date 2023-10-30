package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        OutputView.printStartMessage();
        List<String> stringCarList = InputView.getRacingCars(); // [abc,def,ge]
        System.out.println(stringCarList);
        List<Car> racingCarList = new ArrayList<>();
        for (String stringCar : stringCarList) {
            Car car = new Car(stringCar, 0);
            racingCarList.add(car);
        }

        Race race = new Race(racingCarList);
        OutputView.printTryMessage();
        int tryNumber = InputView.getTryNumber(); // 5
        for (int i = 0; i < tryNumber; i++) {
            race.run();
        }

        OutputView.printShowResultString();
    }
}