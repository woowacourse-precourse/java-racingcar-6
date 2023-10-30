package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final CarName name;
    private final CarMoved moved;

    private final int DEFAULT_MOVED = 0;

    public Car(String name) {
        this.name = new CarName(name);
        this.moved = new CarMoved(DEFAULT_MOVED);
    }
    public Car(String name, int moved) {
        this.name = new CarName(name);
        this.moved = new CarMoved(moved);
    }

    public int move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            moved.increase();
        }
        return moved.getMoved();
    }

    public String getName() {
        return name.getName();
    }

    public int getMoved() {
        return moved.getMoved();
    }
}
