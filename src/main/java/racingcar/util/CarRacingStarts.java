package racingcar.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarRacingStarts {

    private final Map<String, String> carMoveCheck = new LinkedHashMap<>();
    private final PickRandomNumber pickRandomNumber;

    public CarRacingStarts(PickRandomNumber pickRandomNumber) {
        this.pickRandomNumber = pickRandomNumber;
    }

    public Map<String, String> getCarMoveCheck() {
        return carMoveCheck;
    }

    public void creation(List<String> carNames) {

        for (String carName : carNames) {
            int pickRandomNumber = this.pickRandomNumber.Generation();
            String distanceCheck = carMoveCheck.getOrDefault(carName, "");

            if (pickRandomNumber >= 4) {
                distanceCheck += "-";
            }

            carMoveCheck.put(carName, distanceCheck);
        }

    }
}
