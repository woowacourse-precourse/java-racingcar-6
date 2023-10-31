package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class Score {
    private static final String NO_CARS_ERROR = "[ERROR] 자동차가 없습니다.";
    private final int round;
    private final List<ScoreDto> score;

    public Score(int round, List<ScoreDto> score) {
        this.round = round;
        this.score = score;
    }

    public List<ScoreDto> getScore() {
        return score;
    }


    private int findFarthestDistance() {
        return score.stream()
                .max(Comparator.comparing(ScoreDto::getDistance))
                .map(ScoreDto::getDistance)
                .orElseThrow(() -> new IllegalArgumentException(NO_CARS_ERROR));
    }

    public List<ScoreDto> findFarthestScores() {
        return score.stream()
                .filter(carDto -> carDto.isSameDistance(findFarthestDistance()))
                .toList();
    }

    public boolean isSameRound(int round) {
        return this.round == round;
    }

}
