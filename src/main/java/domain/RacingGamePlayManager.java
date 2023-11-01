package domain;

public class RacingGamePlayManager {
    private static final int MOVING_FORWARD_STANDARD_NUMBER = 4;

    public void moveOrStayRacingCars(RacingCar racingCar, int randomValueInRange) {
        if (decideMoveRacingCar(randomValueInRange)) {
            racingCar.moveRacingCar();
        }
    }

    private boolean decideMoveRacingCar(int randomValueInRange) {
        return (randomValueInRange >= MOVING_FORWARD_STANDARD_NUMBER);
    }
}
