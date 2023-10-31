package racingcar.domain;

public class CarList {
    private static final int MOVE = 1;
    private static final int GO_OR_STOP = 3;
    private final String name;
    private final Position position;

    public CarList(String name) {
        this.name = name;
        this.position = new Position();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position.toInt();
    }

    public void moving(int random) {
        if (random > GO_OR_STOP) {
            position.move(MOVE);
        }
    }
}
