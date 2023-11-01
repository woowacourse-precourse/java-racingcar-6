package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Round {
    private static int progressNumber;

    public Round(int inputRound) {
        progressNumber = inputRound;
    }

    public List<Car> rounding(List<Car> inputPlayers) {
        CustomView customView = new CustomView();
        customView.printRoundResult();
        for (int i = 0; i < progressNumber; i++) {
            progress(inputPlayers);
            customView.printEachRound(inputPlayers);
        }
        return inputPlayers;
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