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

        // 이동 거리가 4 이상인 경우만 위치를 증가시킴
        if (moveDistance >= 4) {
            position++;
        }
    }
}
