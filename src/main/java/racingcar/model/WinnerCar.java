package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class WinnerCar {
    private List<String> winnerCarNames;
    private final int winnerStateValue;

    public WinnerCar(List<Car> cars){
        winnerStateValue = cars.stream()
                .sorted(Comparator.comparing(Car::getCarState).reversed())
                .toList()
                .get(0)
                .getCarState();
    }
}
