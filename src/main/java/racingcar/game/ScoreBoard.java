package racingcar.game;

import static racingcar.constant.Constant.DICE_MAX_RANGE;
import static racingcar.constant.Constant.DICE_MIN_RANGE;
import static racingcar.constant.Constant.FORWARD_ABLE_NUMBER;
import static racingcar.constant.Constant.POINT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class ScoreBoard {
    private final Map<String, StringBuilder> scoreBoard;

    public ScoreBoard(Map<String, StringBuilder> scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void updateScore() {
        for (Map.Entry<String, StringBuilder> pair : scoreBoard.entrySet()) {
            if (isMovable()) {
                pair.getValue().append(POINT);
            }
        }
    }

    private int makeRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    private boolean isMovable() {
        return makeRandomNumber(DICE_MIN_RANGE, DICE_MAX_RANGE) >= FORWARD_ABLE_NUMBER;
    }

    public Map<String, StringBuilder> getScoreBoard() {
        return scoreBoard;
    }
}
