package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (isMovable(randomValue)) {
            position++;
        }
    }

    public String getPositionBar() {
        return "-".repeat(position);
    }

    public boolean isMovable(int randomValue) {
        return randomValue >= 4;
    }
}
