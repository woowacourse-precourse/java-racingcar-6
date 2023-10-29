package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RaceGameController {

    private List<Car> carList = new ArrayList<>();
    private List<String> winnerList = new ArrayList<>();
    private int attemptNumber;

    public void start() {

    }

    private void convertCarList(List<String> carInputList) {
        int i = 0;
        while (carInputList.size() > i) {
            Car newCar = new Car(carInputList.get(i));
            carList.add(newCar);
            i++;
        }
    }


}
