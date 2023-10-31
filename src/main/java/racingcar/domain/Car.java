package racingcar.domain;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int number) {
        if(number >= 4) {
            moveCount++;
        }
    }
}
