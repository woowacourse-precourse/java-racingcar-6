package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moved = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[Error]: 자동차 이름이 5자를 넘음");
        }
        this.name = name;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            moved++;
        }
    }

    public MoveInfo info() {
        return new MoveInfo(name, moved);
    }
}
