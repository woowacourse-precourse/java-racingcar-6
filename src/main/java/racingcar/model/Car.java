package racingcar.model;

public class Car {

    public static final int MOVE_FORWARD_THRESHOLD = 4;
    private final String name;
    private String status;

    public Car(String name) {
        this.name = name;
        this.status = "";
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public void moveForward() {
        this.status += "-";
    }
}
