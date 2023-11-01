package racingcar.model;

import java.util.List;

public class GameResult {
    private final List<Car> winnerList;

    public GameResult(List<Car> winnerList) {
        this.winnerList = winnerList;
    }

    public static GameResult of(List<Car> winnerList) {
        return new GameResult(winnerList);
    }

    public List<String> getWinnerCarsNameList() {
        return winnerList.stream()
                .map(Car::getName)
                .toList();
    }
}