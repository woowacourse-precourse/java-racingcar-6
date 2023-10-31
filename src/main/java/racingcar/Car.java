package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {
    String carName;
    Car(String carName) {
        this.carName = carName;
    }

    List<String> movement = new ArrayList<>();
    int forwardMovementNumber = movement.size();
    private int movementRandomNumber = Randoms.pickNumberInRange(0, 9);

    public String getCarName() {
        return carName;
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
