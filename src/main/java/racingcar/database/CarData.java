package racingcar.database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarData {
    private final List<Car> carFactory = new ArrayList<>();
    public void addAll(List<Car> carList) {
        carFactory.addAll(carList);
    }

    public int getCountMax() {
        return carFactory.stream()
                .mapToInt(Car::getProgress)
                .max()
                .getAsInt();
    }

    public List<Car> findAllByProgress(int maxProgress) {
        return carFactory.stream()
                .filter(car -> car.sameProgress(maxProgress))
                .map(car -> new Car(car.getName(),car.getProgress()))
                .collect(Collectors.toList());
    }
}
