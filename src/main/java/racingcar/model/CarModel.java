package racingcar.model;

public class CarModel {
    private final String name;
    private int position;

    public CarModel(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
