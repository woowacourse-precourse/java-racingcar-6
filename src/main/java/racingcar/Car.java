package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    String carName;
    List<String> movement = new ArrayList<String>();
    int forwardMovementNumber = movement.size();
    private final int movementRandomNumber = Randoms.pickNumberInRange(0, 9);
    Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public String drawCarRaceRoad() {
        String road = "-";
        return road.repeat(forwardMovementNumber);
    }

    public String printCarAndRaceRoad(String carName, String road) {
        List<String> carAndRoad = Arrays.asList(carName, road);
        return String.join(":", carAndRoad);
    }

    public int getForwardMovementNumber() {
        return forwardMovementNumber;
    }

    public void decideAction() {
        if (movementRandomNumber >= 4) {
            movement.add("-");
        }
    }
}
