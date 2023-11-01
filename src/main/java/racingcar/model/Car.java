package racingcar.model;

public class Car {
    public static final int MOVE_FORWARD_THRESHOLD = 4;
    private final String name;
    private int status;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public void moveForward() {
        this.status++;
    }

    public String getStatusBar() {
        return "-".repeat(getStatus());
    }
}
