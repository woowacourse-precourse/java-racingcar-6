package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class Score {
    private static final String NO_CARS_ERROR = "[ERROR] 자동차가 없습니다.";
    private final int round;
    private final List<Car> score;

    public Score(int round, List<Car> score) {
        this.round = round;
        this.score = score;
    }

    public List<Car> getScore() {
        return score;
    }


    private int findFarthestDistance() {
        return score.stream()
                .max(Comparator.comparing(Car::getDistance))
                .map(Car::getDistance)
                .orElseThrow(() -> new IllegalArgumentException(NO_CARS_ERROR));
    }

    public List<Car> findFarthestCar() {
        return score.stream()
                .filter(car -> car.isSameDistance(findFarthestDistance()))
                .toList();
    }

    public boolean isSameRound(int round) {
        return this.round == round;
    }
    
}
