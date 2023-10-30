package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.ScoreBoard;

public class ScoreBoardService {
    private final ScoreBoard scoreBoard;

    public ScoreBoardService() {
        this.scoreBoard = new ScoreBoard();
    }

    public void recordRound(int round, List<Car> racingCars) {
        scoreBoard.recordScore(round, racingCars);
    }
    
}
