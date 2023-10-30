package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.validator.Validator;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> racingCarNames) {
        Validator.validateIsDuplicate(racingCarNames);

        cars = new ArrayList<>();
        for (String name : racingCarNames) {
            cars.add(new Car(name, new RandomNumberGenerator()));
        }
    }

    public List<String> findWinner() {
        List<String> winners = new ArrayList<>();
        Car maxCar = cars.get(0);

        for (Car car : cars) {
            int comparisonResult = car.compareTo(maxCar);
            if (comparisonResult > 0) {
                maxCar = car;
                winners.clear();
                winners.add(car.getName());
            }
            if (comparisonResult == 0) {
                winners.add(car.getName());
            }
        }

        return winners;
    }


    public void tryToMoveCars() {
        for (Car car : cars) {
            car.moveOrStay();
        }
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }
}