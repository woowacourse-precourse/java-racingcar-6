package racingcar.model;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
