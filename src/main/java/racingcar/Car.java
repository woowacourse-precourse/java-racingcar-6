package racingcar;

public class Car {

    private String name;
    private int moveCount;

    Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    void moveForward() {
        moveCount += 1;
    }

    String getName() {
        return name;
    }

    int getMoveCount() {
        return moveCount;
    }
}
