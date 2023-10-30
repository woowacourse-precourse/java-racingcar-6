package racingcar.model;

public class RacingCar {
    private static final int FORWARD_THRESHOLD = 4;
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public boolean move(int speed) {
        if (speed >= FORWARD_THRESHOLD) {
            this.position += speed;
            return true;
        }
        return false;
    }
}
