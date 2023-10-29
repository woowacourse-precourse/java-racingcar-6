package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
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

    public String getWinner() {
        int max = Collections.max(position.values());
        List<String> winners = position.keySet()
                .stream()
                .filter(name -> position.get(name).equals(max))
                .toList();
        return String.format("최종 우승자 : %s", String.join(", ", winners));
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
