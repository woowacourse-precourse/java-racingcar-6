package racingcar.game;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    public int calculateForwardPoint(ScoreBoard scoreBoard) {

        return scoreBoard.getScoreBoard()
                .values()
                .stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);
    }

    public List<String> findWinners(int maxForwardPoint, ScoreBoard scoreBoard) {
        List<String> winnerList = new ArrayList<>();

        scoreBoard.getScoreBoard().forEach((key, value) -> {
            if (value.length() == maxForwardPoint) {
                winnerList.add(key);
            }
        });

        return winnerList;
    }
}
