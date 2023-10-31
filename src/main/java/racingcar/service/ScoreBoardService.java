package racingcar.service;

import java.util.List;
import racingcar.model.CarDto;
import racingcar.model.ScoreBoard;

public class ScoreBoardService {
    private final ScoreBoard scoreBoard;

    public ScoreBoardService() {
        this.scoreBoard = new ScoreBoard();
    }

    public void recordRound(int round, List<CarDto> racingCars) {
        this.scoreBoard.recordScore(round, racingCars);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public List<CarDto> findWinners() {
        return scoreBoard.findFinalRoundWinners();
    }

}
