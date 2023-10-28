package racingcar;

public class Car {

    private final String name;
    private Integer forward;

    public Car(String name) {
        this.name = name;
        this.forward = 0;
    }

    public void moveForward() {
        this.forward++;
    }

    public String getName() {
        return this.name;
    }

    public Integer getForward() {
        return this.forward;
    }
}
