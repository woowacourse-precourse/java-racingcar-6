package Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private final StringBuilder position = new StringBuilder();
    public int isMax = 0; // 골에 도착했는지 확인하기 위한 변수

    public Car(String name) {
        this.name = name;
    }

    public void drive() {
        if (isMove()) {
            ++isMax;
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
