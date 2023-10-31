package racingcar.service;

import java.util.List;
import racingcar.model.ScoreBoard;
import racingcar.model.ScoreDto;

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

    public List<ScoreDto> findFinalRoundWinners() {
        return scoreBoard.findFinalRoundWinners();
    }

}
