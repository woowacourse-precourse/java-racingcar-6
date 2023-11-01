package racingcar.model;

public class Driver {

    private String name;
    private int moveCount;

    public Driver(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        this.moveCount += 1;
    }

}
