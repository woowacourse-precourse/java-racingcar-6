package racingcar.domain;

public class RacingCar {

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
    }

    public void updatePosition(int distance) {
        this.position += distance;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}

