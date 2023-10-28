package Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private CarName carName;
    private CarPosition carPosition;

    public Car(String name) {
        carName = new CarName(name);
        carPosition = new CarPosition(0);
    }

    public void moveForward() {
        carPosition.incrementPosition();
    }

    public boolean isNameValid() {
        if (carName.isCarNameEmpty()) {
            return false;
        }
        if (!carName.isNameUnder5Characters()) {
            return false;
        }
        return true;
    }
}
