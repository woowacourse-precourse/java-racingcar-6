package Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int randomNumber;
    private CarName carName;
    private CarPosition carPosition;

    public Car(String name) {
        carName = new CarName(name);
        carPosition = new CarPosition(0);
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

    public void generateRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    // test용 코드
    public boolean isRandomNumberInRange0to9() {
        return randomNumber >= 0 && randomNumber <= 9;
    }
}
