package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    private List<Car> cars;

    public void addCar(String carName) {
        Car car = new Car();
        car.setName(carName);
        cars.add(car);
    }

    public void addCars(List<String> carNames) {
        for (String carName : carNames) {
            addCar(carName);
        }
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