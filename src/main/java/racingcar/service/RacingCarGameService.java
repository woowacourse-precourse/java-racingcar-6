package racingcar.service;

import racingcar.model.RacingCarNames;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGameService {

    private static final int MOVING_FORWARD_STANDARD = 4;

    public LinkedHashMap<String, Integer> racingProgressStatusInitialize(List<String> carNames) {
        LinkedHashMap<String, Integer> racingProgressStatus = new LinkedHashMap<>();
        new RacingCarNames(carNames);
        for (String carName : carNames) {
            racingProgressStatus.put(carName, 0);
        }
        return racingProgressStatus;
    }

    public void playSingleGame(
            RandomNumberGenerator racingNumberGenerator,
            List<String> carNames,
            LinkedHashMap<String, Integer> racingProgressStatus
    ) {
        for (String carName : carNames) {
            int randomNumber = racingNumberGenerator.getRandomNumber();
            processMoveDecision(randomNumber, racingProgressStatus, carName);
        }
    }

    private void processMoveDecision(
            int randomNumber,
            LinkedHashMap<String, Integer> racingProgressStatus,
            String carName
    ) {
        if (isMoveForward(randomNumber)) {
            moveForward(racingProgressStatus, carName);
        }
    }

    public boolean isMoveForward(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD_STANDARD) {
            return true;
        }
        return false;
    }

    public void moveForward(LinkedHashMap<String, Integer> racingProgressStatus, String carName) {
        racingProgressStatus.put(carName, racingProgressStatus.get(carName) + 1);
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

    private void addWinner(
            Map.Entry<String, Integer> finalResultEntry,
            int maxMovingValue,
            List<String> winners
    ) {
        if (finalResultEntry.getValue() == maxMovingValue) {
            winners.add(finalResultEntry.getKey());
        }
    }
}
