package racingcar;

public class Car {

    private String name;
    private int moveCount;

    Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    String getName() {
        return name;
    }

    void moveForward() {
        moveCount += 1;
    }

    int getMoveCount() {
        return moveCount;
    }

}
