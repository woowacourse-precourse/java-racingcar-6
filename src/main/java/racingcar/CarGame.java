package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarGame {

    private final Cars cars;
    private final CarGameRound gameRound;

    private CarGame(Cars cars, CarGameRound gameRound) {
        this.cars = cars;
        this.gameRound = gameRound;
    }

    public static CarGame create(Cars cars, CarGameRound gameRound) {
        return new CarGame(cars, gameRound);
    }

    public List<Map<String, Integer>> race() {
        List<Map<String, Integer>> gameResult = new ArrayList<>();

        for (int i = 0; gameRound.isRunning(i); i++) {
            Map<String, Integer> status = cars.goForward();

            gameResult.add(status);
        }

        return gameResult;
    }

    public List<String> getWinnerNames() {
        return cars.getWinningCarNames();
    }
}
