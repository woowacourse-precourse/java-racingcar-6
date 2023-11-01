package domain;

public class RacingGamePlayManager {
    private static final int MOVING_FORWARD_STANDARD_NUMBER = 4;

    private boolean decideMoveRacingCar(int randomValueInRange) {
        return (randomValueInRange >= MOVING_FORWARD_STANDARD_NUMBER);
    }
}
