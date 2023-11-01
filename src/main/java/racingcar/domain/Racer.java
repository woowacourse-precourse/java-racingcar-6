package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Racer {
    private final String name;
    private int position;

    public Racer(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int moveDistance = Randoms.pickNumberInRange(0, 9);
        if (moveDistance >= 4) {
            position++;
        }
    }
}
