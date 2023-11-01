package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carsList;

    public Cars(List<Car> carsList) {
        this.carsList = (carsList);
    }

    public void runCars() {
        carsList.forEach(Car::moveCar);
    }

    public List<String> getWinnerNameList() {
        List<String> result = new ArrayList<>();
        carsList.forEach(car -> car.addIfWinner(getMaxMoveInCars(), result));
        return result;
    }

    private int getMaxMoveInCars() {
        return carsList.stream()
                .mapToInt(Car::getMove)
                .max()
                .orElse(0);
    }

    @Override
    public String toString() {
        return carsList.stream().map(Car::toString)
                .collect(Collectors.joining("\n", "", "\n"));
    }
}