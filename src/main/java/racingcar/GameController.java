package racingcar;

import java.util.List;

public class GameController {
    private static final int NOT_FOUND_SCORE = -1;

    public List<Car> compareWinner(List<Car> cars) {
        int maxScore = cars.stream().mapToInt(car -> car.getPosition()).max().orElse(NOT_FOUND_SCORE);
        List<Car> winnerList = cars.stream().filter(car -> car.getPosition() == maxScore).toList();
        return winnerList;
    }
}
