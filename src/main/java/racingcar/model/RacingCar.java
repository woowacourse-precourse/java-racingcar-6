package racingcar.model;

public class RacingCar {
    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
