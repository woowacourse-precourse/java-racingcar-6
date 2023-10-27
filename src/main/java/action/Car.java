package action;

import action.Movable;
import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Movable {

    private final static int START = 0;
    private final static int END = 9;
    private final static int MOVE_FORWARD = 4;
    private final static int STOP = 3;

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

    @Override
    public void action() {
        int pickNumber = createRandom();
        if (pickNumber == MOVE_FORWARD) {
            moveForward();
        }
    }

    public void moveForward() {
        status.append("-");
    }

    @Override
    public int createRandom() {
        int pickNumber = Randoms.pickNumberInRange(START, END);
        if (pickNumber >= MOVE_FORWARD) {
            return MOVE_FORWARD;
        }
        return STOP;
    }
}