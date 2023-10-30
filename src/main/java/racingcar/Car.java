package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Car {
    private Output output;

    Car() {
        output = new Output();
    }

    public void move(List<String> carNames, int movingNumber) {
        Map<String, Integer> carNameAndMoving = listToMap(carNames);
        System.out.println("실행 결과");
        while (movingNumber > 0) {
            moveCars(carNames, carNameAndMoving);
            output.printRacingProcess(carNameAndMoving);
            movingNumber--;
        }
        output.printRacingWinner(carNameAndMoving);
    }

    private Map<String, Integer> listToMap(List<String> carNames) {
        Map<String, Integer> carNameAndMoving = new LinkedHashMap<>();

        for (String carName : carNames) {
            carNameAndMoving.put(carName, 0);
        }
        return carNameAndMoving;
    }

    private void moveCars(List<String> carNames, Map<String, Integer> carNameAndMoving) {
        for (String carName : carNames) {
            if (isMovable()) {
                carNameAndMoving.put(carName, carNameAndMoving.getOrDefault(carName, 0) + 1);
            }
        }
    }

    private boolean isMovable() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            return true;
        }
        return false;
    }
}
