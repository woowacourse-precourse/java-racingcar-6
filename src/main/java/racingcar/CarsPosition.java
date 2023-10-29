package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public final class CarsPosition {
    private final Map<String, Integer> position;

    private CarsPosition(Map<String, Integer> position) {
        this.position = position;
    }

    public static CarsPosition createPositionWithRacingCars(RacingCars racingCars) {
        return new CarsPosition(racingCars.createInitPosition());
    }
    
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (String key : position.keySet()) {
            checkStepForward(key);
            sb.append(getNameAndPosition(key));
        }
        return sb.toString();
    }

    private void checkStepForward(String key) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position.put(key, position.get(key) + 1);
        }
    }

    private String getNameAndPosition(String key) {
        return String.format("%s : %s%n", key, convertPositionToSign(key));
    }

    private String convertPositionToSign(String key) {
        return "-".repeat(position.get(key));
    }
}
