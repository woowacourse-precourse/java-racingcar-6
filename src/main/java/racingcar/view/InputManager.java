package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import java.util.Map;

public class InputManager {
    private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String[] inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String[] carNames = Console.readLine().split(",");
        Console.close();
        return carNames;
    }

    public String inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String tryCount = Console.readLine();
        Console.close();
        return tryCount;
    }


    public Boolean isValidateCarName(String carName, Map<String, Integer> carPositions) {
        if (isBlankCarName(carName) || isInvalidCarNameLength(carName) || isContainedCarName(carName, carPositions)) {
            return false;
        }
        return true;
    }

    private Boolean isBlankCarName(String carName) {
        String pattern = "^\\s*$";
        return carName.matches(pattern);
    }

    private Boolean isInvalidCarNameLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            return true;
        }
        return false;
    }

    private Boolean isContainedCarName(String carName, Map<String, Integer> carPositions) {
        return carPositions.containsKey(carName);
    }

    public Map<String, Integer> convertToCarMap(String[] carNames) {
        Map<String, Integer> carMap = new LinkedHashMap<>();
        for (String carName : carNames) {
            if (!isValidateCarName(carName, carMap)) {
                throw new IllegalArgumentException("Invalid CarName");
            }
            carMap.put(carName, 0);
        }
        return carMap;
    }
}
