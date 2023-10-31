package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int MINIMUM_NUMBER_TO_GO = 4;
    public static final int RANDOM_NUMBER_RANGE_MIN = 0;
    public static final int RANDOM_NUMBER_RANGE_MAX = 9;

    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarName();
        int tryNumber = InputView.inputTryNumber();

        OutputView.printResultMessage();
        int[] scores = new int[carNames.size()];
        for (int round = 0; round < tryNumber; round++) {
            race(carNames, scores);
            OutputView.printRaceResult(carNames, scores);
        }

        List<String> winners = getWinners(carNames, scores);
        OutputView.printWinner(winners);
    }

    private static void race(List<String> carNames, int[] scores) {
        for (int i = 0; i < carNames.size(); i++) {
            int goNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_MIN, RANDOM_NUMBER_RANGE_MAX);
            if (goNumber >= MINIMUM_NUMBER_TO_GO) {
                scores[i]++;
            }
        }
    }

    private static List<String> getWinners(List<String> carNames, int[] scores) {
        int maxScore = getMaxScore(scores);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                winners.add(carNames.get(i));
            }
        }
        return winners;
    }

    private static int getMaxScore(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (max < score) {
                max = score;
            }
        }
        return max;
    }
}
