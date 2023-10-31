package racingcar.model;

import racingcar.utils.enums.Constraints;
import racingcar.utils.numbergenerators.NumberGenerator;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    // 기준 만족 시 앞으로 이동
    public void move(NumberGenerator numberGenerator) {
        if (canMove(numberGenerator)) {
            distance++;
        }
    }

    // 앞으로 이동하는 기준
    private boolean canMove(NumberGenerator numberGenerator) {
        return Constraints.MINIMUM_FOR_FORWARD.getValue() <= numberGenerator.generateNumber();
    }

    // 최종 우승자인지 판단
    public boolean isMaxDistance(int maxDistance) {
        return this.distance == maxDistance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}