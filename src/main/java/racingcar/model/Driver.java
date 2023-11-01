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

}
