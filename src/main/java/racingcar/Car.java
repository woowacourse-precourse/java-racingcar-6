package racingcar;

public class Car {
    private final String name;
    private int totalMove = 0; // 이동 누적 거리 == 점수

    Car(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    int getTotalMove() {
        return totalMove;
    }

    void addScore(int move) {
        totalMove += move;
    }
}
