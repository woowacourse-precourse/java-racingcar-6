package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Car {
    private static final String RACING_RESULT = "실행 결과";

    private Result result;

    Car() {
        result = new Result();
    }

    public void move(List<String> carNames, int movingNumber) {
        Map<String, Integer> carNameAndMoving = listToMap(carNames);
        System.out.println(RACING_RESULT);
        while (movingNumber > 0) {
            moveCars(carNameAndMoving);
            result.printRacingProcess(carNameAndMoving);
            movingNumber--;
        }
        result.printRacingWinner(carNameAndMoving);
    }

    private Map<String, Integer> listToMap(List<String> carNames) {
        Map<String, Integer> carNameAndMoving = new LinkedHashMap<>();
        return putZeroToValues(carNames, carNameAndMoving);
    }

    private Map<String, Integer> putZeroToValues(List<String> carNames, Map<String, Integer> carNameAndMoving) {
        for (String carName : carNames) {
            carNameAndMoving.put(carName, 0);
        }
        return carNameAndMoving;
    }

    private void moveCars(Map<String, Integer> carNameAndMoving) {
        for (String carName : carNameAndMoving.keySet()) {
            move(carName, carNameAndMoving);
        }
    }

    private void move(String carName, Map<String, Integer> carNameAndMoving) {
        if (isMovable()) {
            carNameAndMoving.put(carName, carNameAndMoving.get(carName) + 1);
        }
    }

    private boolean isMovable() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }
}
