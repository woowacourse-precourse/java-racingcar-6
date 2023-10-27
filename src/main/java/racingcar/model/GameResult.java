package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<Car> winnerCarList = new ArrayList<>();
    private final int winPosition;

    public GameResult(int winPosition) {
        this.winPosition = winPosition;
    }

    public void addCarList(List<Car> carList) {
        carList.forEach(car -> {
            if (car.getPosition() == this.winPosition) winnerCarList.add(car);
        });
    }

    public String provideWinnderCarName() {
        return winnerCarList.stream().map(Car::getName).collect(Collectors.joining(", "));
    }
}
