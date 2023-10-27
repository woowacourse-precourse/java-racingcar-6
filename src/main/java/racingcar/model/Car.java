package racingcar.model;

import racingcar.utils.Constraints;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

public class Car {
    private final String name;
    private int distance = 0;

    /**
     * 이름만 입력값으로 받으면 RandomNumberGenerator 이용
     */
    public Car(String name) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    /**
     * 기준 만족 시 앞으로 이동
     */
    public void move() {
        if (canMove()) {
            distance++;
        }
    }

    /**
     * 앞으로 이동하는 기준
     */
    private boolean canMove() {
        return Constraints.FORWARD_STANDARD.getValue() <= numberGenerator.generateNumber();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
