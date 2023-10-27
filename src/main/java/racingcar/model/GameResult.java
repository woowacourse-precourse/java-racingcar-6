package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<Car> winnerCarList = new ArrayList<>();
    private int winPosition = 0;

    public void findWinPositionFromCarList(List<Car> carList) {
        carList.forEach(car -> this.winPosition = Math.max(car.getPosition(), this.winPosition));
    }
}
