package action;

import action.Movable;
import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Movable {
    private final static int LENGTH = 5;
    private final static int START = 0;
    private final static int END = 9;
    private final static int MOVE_FORWARD = 4;
    private final static int STOP = 3;

    private final String carName;
    private StringBuilder status;

    public Car(String carName) {
        checkNameLength(carName);

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
    public int action() {
        int pickNumber = createRandom();
        if (pickNumber == MOVE_FORWARD) {
            status.append("-");
        }
        return pickNumber;
    }

    @Override
    public int createRandom() {
        int pickNumber = Randoms.pickNumberInRange(START, END);
        if (pickNumber >= MOVE_FORWARD) {
            return MOVE_FORWARD;
        }
        return STOP;
    }

    public static void checkNameLength(String carName) throws IllegalArgumentException{
        if(carName.length() > LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String printResult() {
        StringBuilder result = new StringBuilder(carName + " : ");
        result.append(status);

        return result.toString();
    }
}
