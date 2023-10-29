package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {
    static int moveCondition = 4;
    public static void main(String[] args) {
        String[] racingCarNames = InputView.inputRacingCarNames();
        int moveCount = InputView.inputMoveCount();
        int[] distances = new int[racingCarNames.length];
        OutputView.printResultMessage();
        for (int i = 0; i < moveCount; ++i) {
            move(distances);
            OutputView.printResult(racingCarNames, distances);
        }
        OutputView.printWinner(getWinners(racingCarNames, distances));
    }

    static void move(int[] distances) {
        for (int i = 0; i < distances.length; ++i) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (randomNumber >= moveCondition) {
                ++distances[i];
            }
        }
    }

    static List<String> getWinners(String[] racingCarNames, int[] distances) {
        List<String> winners = new ArrayList<>();
        int maxDistance = Arrays.stream(distances).max().getAsInt();
        for (int i = 0; i < distances.length; ++i) {
            if (distances[i] == maxDistance) {
                winners.add(racingCarNames[i]);
            }
        }
        return winners;
    }
}
