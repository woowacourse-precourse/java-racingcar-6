package racingcar.domain.victory;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class VictoryManager {
    private List<Car> victoryCars;
    private final VictoryView victoryView;
    public VictoryManager(VictoryView victoryView) {
        this.victoryView = victoryView;
    }

    public void showVictory(List<Car> cars) {
        setVictoryCars(cars);
        victoryView.showVictory(victoryCars);
    }

    private void setVictoryCars(List<Car> cars) {
        victoryCars = calculateVictoryCar(cars, calculateMaxCar(cars));
    }

    private List<Car> calculateVictoryCar(List<Car> cars, Car maxCar) {
        return cars.stream()
                .filter(car -> car.compareTo(maxCar) == 0)
                .collect(Collectors.toList());
    }

    private Car calculateMaxCar(List<Car> cars) {
        return cars.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(NoSuchElementException::new);
    }
}
