package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void moveCars() {
        for (Car car: carList) {
            car.move();
        }
    }

    public List<String> getRoundResult() {
        List<String> result = new ArrayList<>();

        for (Car car: carList) {
            result.add(car.getNameWithPosition());
        }
        return result;
    }

    public List<String> getWinner() {
        final Car highestPositionCar = getHighestPositionCar();
        return getSamePositionCar(highestPositionCar);
    }

    private Car getHighestPositionCar() {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<String> getSamePositionCar(Car highestPositionCar) {
        return carList.stream()
                .filter(highestPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
