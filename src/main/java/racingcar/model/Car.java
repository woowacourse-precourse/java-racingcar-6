package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    static final int MAX_MOVE_NUMBER = 9;
    static final int MIN_MOVE_NUMBER = 0;
    static final  int MOVE_CRITERION = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = MIN_MOVE_NUMBER;
    }

    public int makeRandom() {
        return Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER);
    }

    public void move() {
        int moveNumber = makeRandom();
        if (moveNumber >= MOVE_CRITERION) {
            position ++;
        }
    }
}
