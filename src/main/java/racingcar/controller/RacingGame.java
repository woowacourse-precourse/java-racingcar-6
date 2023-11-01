package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Computer;
import racingcar.model.User;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final User user;
    private final Computer computer;

    public RacingGame(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    public List<Car> StringListChangeCarList() {
        List<String> carNames = user.inputCarNames();

        List<Car> carList = new ArrayList<>();

        for(String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }
}
