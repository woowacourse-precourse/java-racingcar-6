package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        this.cars = generateToCars(cars);
    }

    private List<Car> generateToCars(List<String> cars) {
        return cars.stream()
                .map(name -> new Car(new Name(name)))
                .toList();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> selectWinners() {
        int maxMoved = getMaxMoved();

        return cars.stream()
                .filter(car -> car.moved() == maxMoved)
                .map(Car::name)
                .toList();
    }

    private int getMaxMoved() {
        return cars.stream()
                .mapToInt(car -> car.moved())
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public int size() {
        return cars.size();
    }

    public Car get(int i) {
        return cars.get(i);
    }
}
