package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class AskCarName {
    public Map<String, Integer> askCarName() {
        String inputCarName = Console.readLine();

        if (checkCarName(inputCarName)) {
            return splitCarName(inputCarName);
        } else {
            if (validateLengthOfCarName(inputCarName)) {
                Map<String, Integer> result = new HashMap<>();
                result.put(inputCarName, 0);

                return result;
            } else {
                throw new IllegalArgumentException();
            }
        }

    }

    private boolean checkCarName(String inputCarName) {
        if (inputCarName.contains(",")) {
            return true;
        } else {
            return false;
        }
    }

    private Map<String, Integer> splitCarName(String inputCarName) {
        String[] strSplit = inputCarName.split(",");
        Map<String, Integer> result = new HashMap<>();

        for (String carName : strSplit) {
            if (validateLengthOfCarName(carName)) {
                result.put(carName, 0);
            } else {
                throw new IllegalArgumentException();
            }
        }

        return result;
    }

    private boolean validateLengthOfCarName(String carName) {
        if (carName.length() < 5) {
            return true;
        } else {
            return false;
        }
    }
}
