package racingcar.service;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGameService {

    private static final int MOVING_FORWARD_STANDARD = 4;

    public LinkedHashMap<String, Integer> initializeRacingProgressStatus(List<String> carNames) {
        LinkedHashMap<String, Integer> racingProgressStatus = new LinkedHashMap<>();
        for (String carName : carNames) {
            racingProgressStatus.put(carName, 0);
        }
        return racingProgressStatus;
    }

    public void playSingleGame(RandomNumberGenerator racingNumberGenerator, List<String> carNames, LinkedHashMap<String, Integer> racingProgressStatus) {
        for (String carName : carNames) {
            int randomNumber = racingNumberGenerator.getRandomNumber();
            processMoveDecision(randomNumber, racingProgressStatus, carName);
        }
    }

    private void processMoveDecision(int randomNumber, LinkedHashMap<String, Integer> racingProgressStatus, String carName) {
        if (isMoveForward(randomNumber)) {
            moveForward(racingProgressStatus, carName);
        }
    }

    private boolean isMoveForward(int randomNumber) {
        return randomNumber >= MOVING_FORWARD_STANDARD;
    }

    private void moveForward(LinkedHashMap<String, Integer> racingProgressStatus, String carName) {
        racingProgressStatus.put(carName, racingProgressStatus.get(carName) + 1);
    }

    public List<String> getWinners(LinkedHashMap<String, Integer> finalResult) {
        int maxMovingValue = getMaxMovingValue(finalResult);
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> finalResultEntry : finalResult.entrySet()) {
            addWinner(finalResultEntry, maxMovingValue, winners);
        }
        return winners;
    }

    private int getMaxMovingValue(LinkedHashMap<String, Integer> finalResult) {
        int maxMovingValue = Integer.MIN_VALUE;
        for (int movingValue : finalResult.values()) {
            maxMovingValue = compareMovingValue(movingValue, maxMovingValue);
        }
        return maxMovingValue;
    }

    private int compareMovingValue(int movingValue, int maxMovingValue) {
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
