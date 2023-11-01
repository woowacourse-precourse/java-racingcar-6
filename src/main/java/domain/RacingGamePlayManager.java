package domain;

public class RacingGamePlayManager {
    private static final int MOVING_FORWARD_STANDARD_NUMBER = 4;
    private static final String MOVING_FORWARD_SYMBOL = "-";

    public void moveOrStayRacingCars(RacingCar racingCar, int randomValueInRange) {
        if (decideMoveRacingCar(randomValueInRange)) {
            racingCar.moveRacingCar();
        }
    }

    public String getMoveResult(RacingCar racingCar) {
        return racingCar.getName() + " : " + MOVING_FORWARD_SYMBOL.repeat(racingCar.getMoveCount());
    }

    private boolean decideMoveRacingCar(int randomValueInRange) {
        return (randomValueInRange >= MOVING_FORWARD_STANDARD_NUMBER);
    }
}
