package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Round {
    private static int progressNumber;

    public Round(int inputRound) {
        progressNumber = inputRound;
    }

    public void rounding(Car[] inputPlayers) {
        for (int i = 0; i < progressNumber; i++) {
            progress(inputPlayers);
        }
    }

    public void progress(Car[] inputPlayers) {
        for (Car player : inputPlayers) {
            int countCondition = Randoms.pickNumberInRange(0, 9);
            if (countCondition > 3) {
                player.move();
            }
        }
    }
}