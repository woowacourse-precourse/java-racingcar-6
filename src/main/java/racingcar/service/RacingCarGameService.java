package racingcar.service;

import java.util.LinkedHashMap;

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
}
