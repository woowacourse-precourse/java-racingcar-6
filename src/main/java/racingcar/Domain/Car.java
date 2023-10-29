package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int START_POSITION = 0;
    private static final int TICK = 1;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }
}
