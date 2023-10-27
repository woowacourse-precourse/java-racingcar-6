package racingcar.domain;

import java.util.List;
import java.util.OptionalInt;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public void move() {
        for (Car car : cars) {
            car.moveIfSatisfy();
        }
    }

    public void printCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public List<Car> getWinnerList() {
        OptionalInt maxOptional = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max();
        int max = maxOptional.orElse(0);
        return cars.stream()
                .filter(car -> car.getMoveCount() == max)
                .toList();
    }
}
