package racingcar.model;

import java.util.ArrayList;
import java.util.List;

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
}
