package racingcar.game;

import racingcar.game.domain.Car;
import racingcar.game.domain.Round;

import java.util.ArrayList;
import java.util.List;

public class GameSetting {

    private final List<Car> cars;
    private Round round;

    public GameSetting() {
        this.cars = new ArrayList<>();
        this.round = null;
    }

    public void initializeCars(List<String> carNameList) {
        for (String carName : carNameList) {
            cars.add(Car.create(carName));
        }
    }

    public void initializeRound(int round) {
        this.round = Round.create(round);
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
        return round.getMovingCount();
    }
}
