package racingcar;

public class Car {
    private String name;
    private StringBuilder moveTrace;
    private int moveCount;

    Car(String name) {
        this.name = name;
    }

    public void setMoveTrace() {

    }

    public void setMoveCount() {
    }

    public String getName() {
        return name;
    }
    public StringBuilder getMoveTrace() {
        return moveTrace;
    }
    public int getMoveCount() {
        return moveCount;
    }
}
