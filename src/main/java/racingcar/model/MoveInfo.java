package racingcar.model;

public class MoveInfo {
    private final CarName name;
    private final CarMoved moved;

    public MoveInfo(CarName name, CarMoved moved) {
        this.name = name;
        this.moved = moved;
    }

    public String getName() {
        return name.getName();
    }

    public int getMoved() {
        return moved.getMoved();
    }
}
