package racingcar.domain;

import racingcar.common.strategy.MoveStrategy;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    // 이동
    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            increaseDistance();
        }
    }

    // 거리 증가
    private void increaseDistance() {
        distance++;
    }

    // 승자인지 판별
    public boolean isWinner(int winnerDistance) {
        return this.distance == winnerDistance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
