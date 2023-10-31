package racingcar.service;

import java.util.List;
import racingcar.model.ScoreDto;
import racingcar.model.ScoreBoard;

public class ScoreBoardService {
    private final ScoreBoard scoreBoard;

    public ScoreBoardService() {
        this.scoreBoard = new ScoreBoard();
    }

    public void recordRound(int round, List<ScoreDto> racingCars) {
        this.scoreBoard.recordScore(round, racingCars);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public List<ScoreDto> findWinners() {
        return scoreBoard.findFinalRoundWinners();
    }

}
