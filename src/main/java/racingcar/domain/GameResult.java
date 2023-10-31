package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameResult {
    public String gameResult(int winnerPoint, List<String> carNameList, Map<String, Integer> point) {
        String result = "";
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < carNameList.size(); i++) {
            if (point.get(carNameList.get(i)).intValue() == winnerPoint) {
                winner.add(carNameList.get(i));
            }

            result = String.join(", ", winner);
        }

        return result;
    }
}
