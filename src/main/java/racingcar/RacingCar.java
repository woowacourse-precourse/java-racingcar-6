package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
