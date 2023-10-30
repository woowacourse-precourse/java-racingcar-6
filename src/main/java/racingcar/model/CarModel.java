package racingcar.model;

public class CarModel {
    private String name;
    private int forward;

    public CarModel(String name) {
        this.name = name;
        this.forward = 0;
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

    public int increaseForward() {
        this.forward += 1;
        return this.forward;
    }
}
