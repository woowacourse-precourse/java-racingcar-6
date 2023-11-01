package racingcar.Service;

import racingcar.Domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(String inputCarsString) {
        this.cars = this.createCars(inputCarsString);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(String inputCarsString) {
        List<String> carNames = new ArrayList<String>();
        Collections.addAll(carNames, inputCarsString.split(","));

        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name, 0));
        }

        return carList;
    }

    public List<Car> racing() {
        for (Car car : this.cars) {
            car.move();
        }

        return this.cars;
    }

    public List<String> findWinners() {
        Integer highestPoint = findHighestPoint();
        List<String> winnerList = findCarNames(highestPoint);

        return winnerList;
    }

    private Integer findHighestPoint() {
        List<Integer> carPointList = new ArrayList<>();
        for (Car car : this.cars) {
            carPointList.add(car.getPoint());
        }
        Integer highestPoint = Collections.max(carPointList);

        return highestPoint;
    }

    private List<String> findCarNames(Integer highestPoint) {
        List<String> names = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.point.equals(highestPoint)) {
                names.add(car.name);
            }
        }

        return names;
    }
}
