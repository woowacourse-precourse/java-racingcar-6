package racingcar;

public class RacingCar {

    private static final int MOVING_POINT = 1;
    private static final int STARTING_POSITION = 0;

    private final String name;
    private final RacingCarMovingStrategy racingCarMovingStrategy;

    private int position;

    public RacingCar(String name, RacingCarMovingStrategy racingCarMovingStrategy) {
        this.name = name;
        this.position = STARTING_POSITION;
        this.racingCarMovingStrategy = racingCarMovingStrategy;
    }

    public void race() {
        if (racingCarMovingStrategy.canMoveForward()) {
            position += MOVING_POINT;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
