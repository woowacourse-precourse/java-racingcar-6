package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarGame {

    private final Cars cars;
    private final int gameRound;

    private CarGame(Cars cars, int gameRound) {
        this.cars = cars;
        this.gameRound = gameRound;
    }

    public static CarGame create(Cars cars, int gameRound) {
        return new CarGame(cars, gameRound);
    }

    public List<Map<String, Integer>> race() {
        List<Map<String, Integer>> gameResult = new ArrayList<>();

        for (int i = 0; i < gameRound; i++) {
            Map<String, Integer> status = cars.goForward();

            gameResult.add(status);
        }

        return gameResult;
    }

    public List<String> getWinnerNames() {
        return cars.getWinningCarNames();
    }
}
