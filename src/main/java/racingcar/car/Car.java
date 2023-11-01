package racingcar.car;

public class Car {

    public static final int FORWARD_MOVE_INIT_COUNT = 0;
    public static final String COLON = " : ";
    public static final String DASH = "-";
    private int forwardMoveCount;
    private final String name;

    private Car(String name) {
        this.name = name;
        this.forwardMoveCount = FORWARD_MOVE_INIT_COUNT;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move() {
        this.forwardMoveCount++;
    }

    public String makeResult() {
        return new StringBuilder()
            .append(name)
            .append(COLON)
            .append(DASH.repeat(forwardMoveCount))
            .toString();
    }

    public String getName() {
        return this.name;
    }
    public int getForwardMoveCount() {
        return this.forwardMoveCount;
    }
}
