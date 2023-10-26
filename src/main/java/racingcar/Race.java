package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    public List<Car> cars;

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
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