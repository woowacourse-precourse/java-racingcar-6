package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    List<Car> racingCarList;
    public void start() {
        OutputView.printStartMessage();
        makeCarList(InputView.getRacingCars());
        Race race = new Race(racingCarList);
        OutputView.printTryMessage();
        int tryNumber = InputView.getTryNumber();
        OutputView.printShowResultString();
        for (int i = 0; i < tryNumber; i++) {
            race.run();
            System.out.println();
        }
    }

    private void makeCarList(List<String> stringCarList) {
        racingCarList = new ArrayList<>();
        for (String stringCar : stringCarList) {
            Car car = new Car(stringCar, 0);
            racingCarList.add(car);
        }
    }
}