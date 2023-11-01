package racingcar.model;

import static racingcar.model.GameRule.GAME_COUNT_LOWER_LIMIT;

import java.util.List;

public class Game {

    private final Cars cars;
    private final GameCount gameCount;

    public Game(List<String> names, int count) {
        this.cars = new Cars(names);
        this.gameCount = new GameCount(count);
    }

    public void oneRace() {
        cars.moveCars();
        gameCount.reduceCount();
    }

    public boolean isPlayable() {
        if (gameCount.getCount() < GAME_COUNT_LOWER_LIMIT) {
            return false;
        }
        return true;
    }

    public String getCurrentCarPositions() {
        return cars.oneRaceResult();
    }

    public String getWinners() {
        return cars.getWinners();
    }

}
