package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    List<String> winner = new ArrayList<>();

    public List<String> gameResult(List<String> carNameList, List<Integer> forwardCountInt) {
        for (int i = 0; i < carNameList.size(); i++) {
            if (forwardCountInt.get(i) == Collections.max(forwardCountInt)) {
                winner.add(carNameList.get(i));
            }
        }
        return winner;
    }

    public String insertSeparator(List<String> winnerList) {
        return String.join(", ", winnerList);
    }
}
