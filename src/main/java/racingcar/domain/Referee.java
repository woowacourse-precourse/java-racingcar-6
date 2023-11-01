package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    public List<String> getWinner(List<String> carNames, List<Integer> scores) {
        int max = 0;
        List<String> winner = new ArrayList<String>();
        for (int carIdx = 0; carIdx < scores.size(); carIdx++) {
            if (scores.get(carIdx) > max) {
                max = scores.get(carIdx);
            }
        }
        for (int carIdx = 0; carIdx < scores.size(); carIdx++) {
            if (scores.get(carIdx) == max) {
                winner.add(carNames.get(carIdx));
            }
        }
        return winner;
    }
}
