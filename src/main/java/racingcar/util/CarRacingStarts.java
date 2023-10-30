package racingcar.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarRacingStarts {

    private final Map<String, String> carsDistanceData = new LinkedHashMap<>();
    private final PickRandomNumber pickRandomNumber;

    public CarRacingStarts(PickRandomNumber pickRandomNumber) {
        this.pickRandomNumber = pickRandomNumber;
    }

    public Map<String, String> getCarsDistanceData() {
        return carsDistanceData;
    }



    public void creation(List<String> carNames) {

        for (String carName : carNames) {
            int pickRandomNumber = this.pickRandomNumber.Generation();
            String distanceCheck = carsDistanceData.getOrDefault(carName, "");

            if (pickRandomNumber >= 4) {
                distanceCheck += "-";
            }

            carsDistanceData.put(carName, distanceCheck);
        }

    }
}
