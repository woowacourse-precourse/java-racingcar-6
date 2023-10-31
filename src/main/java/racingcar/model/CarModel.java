package racingcar.model;

public class CarModel {
    private String name;
    private int forward;

    public CarModel(String name) {
        this.name = name;
        this.forward = 0;
    }

    public CarModel(String name, int forward) {
        this.name = name;
        this.forward = forward;
    }

    public int increaseForward() {
        this.forward += 1;
        return this.forward;
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.forward);
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }
}
