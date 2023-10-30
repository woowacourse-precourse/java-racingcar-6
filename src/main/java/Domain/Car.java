package Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private final StringBuilder position = new StringBuilder("-");

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (isMove()) {
            position.append("-");
        }
    }

    private boolean isMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }

    public String getPosition() {
        return position.toString();
    }

    public String getName() {
        return name;
    }
}
