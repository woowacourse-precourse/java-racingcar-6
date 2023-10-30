package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int DEFAULT_MOVED = 0;
    private final int MOVE_THRESHOLD = 4;
    private final int RANDOM_START = 0;
    private final int RANDOM_END = 9;

    private final CarName name;
    private final CarMoved moved;

    public Car(String name) {
        this.name = new CarName(name);
        this.moved = new CarMoved(DEFAULT_MOVED);
    }
    public Car(String name, int moved) {
        this.name = new CarName(name);
        this.moved = new CarMoved(moved);
    }

    public int move() {
        int random = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
        if (random >= MOVE_THRESHOLD) {
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
