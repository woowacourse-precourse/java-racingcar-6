package racingcar.race;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.PickRandomNumber;

public class Car {

    private final Map<String, String> carsDistanceData = new LinkedHashMap<>();
    private final PickRandomNumber pickRandomNumber;

    public Car(PickRandomNumber pickRandomNumber) {
        this.pickRandomNumber = pickRandomNumber;
    }

    public Map<String, String> getCarsDistanceData() {
        return carsDistanceData;
    }


    public void racingStarts(List<String> carNames) {

        for (String carName : carNames) {
            int pickRandomNumber = this.pickRandomNumber.Generation();
            StringBuilder distanceCheck = new StringBuilder(carsDistanceData.getOrDefault(carName, ""));

            moveNumberFourMore(pickRandomNumber, distanceCheck);

            carsDistanceData.put(carName, distanceCheck.toString());
        }

    }

    private void moveNumberFourMore(int pickRandomNumber, StringBuilder distanceCheck) {
        if (pickRandomNumber >= 4) {
            distanceCheck.append("-");
        }
    }
}
