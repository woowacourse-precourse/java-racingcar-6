package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<Score> scoreBoard;

    public ScoreBoard() {
        this.scoreBoard = new ArrayList<>();
    }

    public void recordScore(int round, List<CarDto> score) {
        this.scoreBoard.add(new Score(round, score));
    }

    public List<CarDto> getScoreForRound(int round) {
        return scoreBoard.stream()
                .filter(score -> score.isSameRound(round))
                .flatMap(score -> score.getScore().stream())
                .toList();
    }

    public int getSize() {
        return scoreBoard.size();
    }

    public List<CarDto> findFinalRoundWinners() {
        return scoreBoard.get(getFinalRound()).findFarthestCar();
    }

    public int getFinalRound() {
        return scoreBoard.size() - 1;
    }

}
