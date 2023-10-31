package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class Score {
    private static final String NO_CARS_ERROR = "[ERROR] 자동차가 없습니다.";
    private final int round;
    private final List<CarDto> score;

    public Score(int round, List<CarDto> score) {
        this.round = round;
        this.score = score;
    }

    public List<CarDto> getScore() {
        return score;
    }


    private int findFarthestDistance() {
        return score.stream()
                .max(Comparator.comparing(CarDto::getDistance))
                .map(CarDto::getDistance)
                .orElseThrow(() -> new IllegalArgumentException(NO_CARS_ERROR));
    }

    public List<CarDto> findFarthestCar() {
        return score.stream()
                .filter(carDto -> carDto.isfathestDistance(findFarthestDistance()))
                .toList();
    }

    public boolean isSameRound(int round) {
        return this.round == round;
    }

}
