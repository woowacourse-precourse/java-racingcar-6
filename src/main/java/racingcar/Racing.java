package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    private String name;
    private int distance;

    public Racing(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
