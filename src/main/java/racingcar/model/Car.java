package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final CarName name;
    private int moved = 0;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public int move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            moved++;
        }
        return moved;
    }

    public MoveInfo info() {
        return new MoveInfo(name, moved);
    }
}
