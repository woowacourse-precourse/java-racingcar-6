package racingcar.game;

import racingcar.game.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameSetting {

    private final List<Car> cars;
    private int round = 0;

    public GameSetting() {
        this.cars = new ArrayList<>();
    }

    public void initializeCars(List<String> carNameList) {
        for (String carName : carNameList) {
            cars.add(Car.create(carName));
        }
    }

    public void initializeRound(String round) {
        this.round = Integer.parseInt(round);
    }

    public void tryCarsForward() {
        for (Car car : cars) {
            car.tryForward();
        }
    }

    public List<String> getCarsState() {
        List<String> carStateList = new ArrayList<>();

        for (Car car : cars) {
            carStateList.add(car.getCarState());
        }

        return carStateList;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getRound() {
        return this.round;
    }
}
