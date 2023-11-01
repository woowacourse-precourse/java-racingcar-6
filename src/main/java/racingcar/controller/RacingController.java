package racingcar.controller;

import racingcar.domain.Car;
import racingcar.printer.Input;
import racingcar.util.RacingCarUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private RacingCarUtil racingCarUtil;
    final Integer MOVEMENT = 0;
    final String DASH = "";

    public void runGame() {
        List<String> carList = setCarList();
        int count = setCount();
        setGame(carList, count);
        gameStart();
    }

    private void gameStart() {
        racingCarUtil.start();
    }

    private List<String> setCarList() {
        return Input.getCars();
    }

    private int setCount() {
        return Input.gameNumber();
    }

    private void setGame(List<String> carList, int gameCount) {
        List<Car> cars = setCars(carList);
        racingCarUtil = new RacingCarUtil(cars, gameCount);
    }

    private List<Car> setCars(List<String> carList) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carList) {
            cars.add(new Car(carName, MOVEMENT, DASH));
        }
        return cars;
    }
}
