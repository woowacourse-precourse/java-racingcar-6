package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Car {
    private Output output;

    Car() {
        output = new Output();
    }

    public void move(List<String> carNames, int movingNumber) {
        Map<String, Integer> carNameAndMoving =
                carNames.stream().collect(Collectors.toMap(
                        carName -> carName,
                        carName -> 0)
                );

        while (movingNumber > 0) {
            for (String carName : carNames) {
                if (isMovable()) {
                    carNameAndMoving.put(carName, carNameAndMoving.getOrDefault(carName, 0) + 1);
                }
            }
            output.printRacingProcess(carNameAndMoving);
            movingNumber--;
        }
        output.printRacingWinner(carNameAndMoving);
    }

    private boolean isMovable() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            return true;
        }
        return false;
    }
}
