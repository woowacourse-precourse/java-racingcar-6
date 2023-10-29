package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<String> winners;

    public RacingGame() {
        this.winners = new ArrayList<>();
    }

    public List<String> getWinners(List<Car> carList) {
        this.winners = carList.stream()
                .filter(car -> car.isLocationEqual(getMaxLocation(carList)))
                .map(Car::getName)
                .collect(Collectors.toList());

        return winners;
    }

    public int getMaxLocation(List<Car> carList) {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get().getLocation();
    }

}
