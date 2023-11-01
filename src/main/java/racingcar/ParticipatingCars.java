package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ParticipatingCars {
    private List<Car> cars;

    ParticipatingCars() {
        this.cars = new ArrayList<>();
    }

    public void registerEachCar(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public void moveEachCar(Supplier<Integer> fuelSupplier) {
        cars.forEach(car -> car.tryMove(fuelSupplier.get()));
    }

    List<String> getWinnersNames() {
        int furthestLocation = findFurthestLocation();
        return cars.stream()
                .filter(car -> car.getLocation() == furthestLocation)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findFurthestLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    List<Car> getCars() {
        return cars;
    }
}
