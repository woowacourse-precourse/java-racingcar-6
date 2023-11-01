package action;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Constant;

public class Car {

    private final String carName;
    private final StringBuilder status;

    public Car(String carName) {
        this.carName = carName;
        status = new StringBuilder();
    }

    public String getCarName() {
        return carName;
    }

    public String getStatus() {
        return status.toString();
    }

    public void action() {
        int pickNumber = Randoms.pickNumberInRange(Constant.START, Constant.END);
        if (pickNumber >= Constant.MOVE_FORWARD) {
            moveForward();
        }
    }

    public void moveForward() {
        status.append("-");
    }
}