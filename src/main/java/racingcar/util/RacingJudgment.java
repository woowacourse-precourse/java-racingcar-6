package racingcar.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.dto.RacingStatus;

public class RacingJudgment {

    public List<String> findWinner(RacingStatus status) {
        int furthestDistance = findFurthestDistance(status);
        List<String> winner = new ArrayList<String>();

        for (String carName : status.getCarNames()) {
            if (furthestDistance == status.getCarPosition(carName).length()) {
                winner.add(carName);
            }
        }
        return winner;
    }

    private int findFurthestDistance(RacingStatus status) {
        List<Integer> distances = new ArrayList<Integer>();
        for (String distance : status.getCarList().values()) {
            distances.add(distance.length());
        }
        return Collections.max(distances);
    }
}
