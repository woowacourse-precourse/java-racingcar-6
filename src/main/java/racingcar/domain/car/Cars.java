package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCars(String[] carNames ) {
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
    }

    public void moveCars() {
        cars.stream()
                .forEach(Car::tryMoveForward);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int max = getMaxDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == max)
                .toList();
    }

    private int getMaxDistance() {
        return cars.stream()
                .map(Car::getDistance)
                .max(Comparator.naturalOrder())
                .get();
    }
}
