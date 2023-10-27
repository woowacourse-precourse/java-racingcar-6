package racingcar.model;

public class MoveInfo {
    private final CarName name;
    private final int moved;

    public MoveInfo(CarName name, int moved) {
        this.name = name;
        this.moved = moved;
    }

    public String getName() {
        return name.getName();
    }

    public int getMoved() {
        return moved;
    }
}
