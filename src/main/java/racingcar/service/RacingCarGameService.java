package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGameService {

    private static final int MOVING_FORWARD_STANDARD = 4;

    public boolean isMovingForward(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD_STANDARD) {
            return true;
        }
        return false;
    }

    public void moveForward(LinkedHashMap<String, Integer> progressStatus, String carName) {
        progressStatus.put(carName, progressStatus.get(carName) + 1);
    }

    public List<String> getWinners(LinkedHashMap<String, Integer> finalResult) {
        int maxMovingValue = Integer.MIN_VALUE;
        for (int movingValue : finalResult.values()) {
            maxMovingValue = getMaxMovingValue(movingValue, maxMovingValue);
        }
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> finalResultEntry : finalResult.entrySet()) {
            addWinner(finalResultEntry, maxMovingValue, winners);
        }
        return winners;
    }

    private int getMaxMovingValue(int movingValue, int maxMovingValue) {
        if (movingValue > maxMovingValue) {
            return movingValue;
        }
        return maxMovingValue;
    }

    private void addWinner(Map.Entry<String, Integer> finalResultEntry, int maxMovingValue, List<String> winners) {
        if (finalResultEntry.getValue() == maxMovingValue) {
            winners.add(finalResultEntry.getKey());
        }
    }
}
