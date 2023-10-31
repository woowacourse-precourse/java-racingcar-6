package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.InputValueValidator;

public class RacingGame {

    private List<String> winners;
    private final InputValueValidator inputValueValidator;

    public RacingGame() {
        this.winners = new ArrayList<>();
        this.inputValueValidator = new InputValueValidator();
    }

    public List<String> getWinners(List<Car> carList) {
        this.winners = carList.stream()
                .filter(car -> car.isLocationEqual(getMaxLocation(carList)))
                .map(Car::getName)
                .collect(Collectors.toList());

        return winners;
    }

    private int getMaxLocation(List<Car> carList) {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get().getLocation();
    }

    public int getTryCount(String tryCount) {
        return inputValueValidator.validateTryCount(tryCount);
    }

}
