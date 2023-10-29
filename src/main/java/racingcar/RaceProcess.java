package racingcar;

import static racingcar.constant.Constant.DICE_MAX_RANGE;
import static racingcar.constant.Constant.DICE_MIN_RANGE;
import static racingcar.constant.Constant.FORWARD_ABLE_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import racingcar.util.Printer;

public class RaceProcess {
    private final Printer printer = new Printer();
    private Map<String, StringBuilder> resultScore;

    public void playGame(int gameRound, Map<String, StringBuilder> scoreBoard) {
        printer.printResultMessage();

        for (int i = 0; i < gameRound; i++) {
            playOneRound(scoreBoard);
            System.out.println();
        }
        this.resultScore = scoreBoard;
    }

    private void playOneRound(Map<String, StringBuilder> scoreBoard) {
        for (Map.Entry<String, StringBuilder> pair : scoreBoard.entrySet()) {
            if (isMovable()) {
                addPoint(pair.getValue());
            }
            printer.printRoundResult(pair);
        }
    }

    private int makeRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    private boolean isMovable() {
        return makeRandomNumber(DICE_MIN_RANGE, DICE_MAX_RANGE) >= FORWARD_ABLE_NUMBER;
    }

    private StringBuilder addPoint(StringBuilder beforeScore) {
        return beforeScore.append("-");
    }

    public Map<String, StringBuilder> getResultScore() {
        return resultScore;
    }
}
