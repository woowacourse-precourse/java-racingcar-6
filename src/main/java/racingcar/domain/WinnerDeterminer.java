package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerDeterminer {
    public List<String> determineWinners(List<String> carNames, List<Integer> moves) {
        int maxMove = Collections.max(moves);
        List<String> winners = new ArrayList<>();

        for (int i=0; i<carNames.size(); i++) {
            if (moves.get(i) == maxMove) {
                winners.add(carNames.get(i));
            }
        }

        return winners;
    }   
}
