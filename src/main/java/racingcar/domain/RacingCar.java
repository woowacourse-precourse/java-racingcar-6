package racingcar.domain;

public class RacingCar {

    private final static int DEFAULT_POSITION = 0;

    public final static int MAX_RACING_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
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

