package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Round {
    private static int progressNumber;

    public Round(int inputRound) {
        progressNumber = inputRound;
    }

    public void rounding(List<Car> inputPlayers) {
        for (int i = 0; i < progressNumber; i++) {
            progress(inputPlayers);
        }
    }

    public void progress(List<Car> inputPlayers) {
        for (Car player : inputPlayers) {
            int countCondition = Randoms.pickNumberInRange(0, 9);
            if (countCondition > 3) {
                player.move();
            }
        }
    }
}