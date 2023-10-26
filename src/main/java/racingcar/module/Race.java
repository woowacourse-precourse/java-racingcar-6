package racingcar.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    ArrayList<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public ArrayList<String> getWinner() {
        final Car car = findFarthest();

        return carList.stream()
                .filter(car::isAtSamePos)
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void simulateTurn() {
        carList.forEach(Car::turnAction);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    Car findFarthest() {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalAccessError::new);
    }


}
