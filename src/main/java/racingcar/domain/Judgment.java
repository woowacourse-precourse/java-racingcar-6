package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Judgment {
    private static final int OFFSET = 1;
    private static final int LIMIT = 9;

    private static HashMap<String, String> result = new HashMap<>();
    private static Judgment judgment;

    private Judgment() {
    }

    public static Judgment getInstance() {
        if (judgment == null) {
            return new Judgment();
        }
        return judgment;
    }

    public HashMap<String, String> getExecutionResult(List<String> cars) {

        for (String car : cars) {
            String spaceMoved = "";

            int randomNum = getRandomNumber();

            if (canMoveForward(randomNum)) {
                spaceMoved += "-";
            }
            result.put(car, spaceMoved);
        }

        return result;
    }

    private boolean canMoveForward(int randomNum) {
        return randomNum >= 4;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(OFFSET, LIMIT);
    }
}
