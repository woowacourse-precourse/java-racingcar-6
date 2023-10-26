package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    private List<Car> cars;

    private void addCar(String carName) {
        Car car = new Car();
        car.setName(carName);
        cars.add(car);
    }

    void addCars(List<String> carNames) {
        for (String carName : carNames) {
            addCar(carName);
        }
    }

    List<Car> getCars() {
        return cars;
    }

    List<Car> getWinner() {
        List<Car> carsCopy = new ArrayList<>();
        carsCopy.addAll(cars);

        Car first = carsCopy.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get();
        int firstCarPosition = first.getPosition();
        List<Car> winner = carsCopy.stream()
                .filter(car -> car.getPosition() == firstCarPosition)
                .toList();
        return winner;
    }
}