package race;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiceNumber {

    Map<String, String> carMoveCheck = new LinkedHashMap<>();
    RandomNumber randomNumber;

    public DiceNumber(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void creation(List<String> carNames) {

        for (String carName : carNames) {
            int dice = randomNumber.Generation();
            String distanceCheck = carMoveCheck.getOrDefault(carName, "");

            if (dice >= 4) {
                distanceCheck += "-";
            }

            carMoveCheck.put(carName, distanceCheck);
        }

    }
}
