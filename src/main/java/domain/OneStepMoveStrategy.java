package domain;

public class OneStepMoveStrategy implements MoveStrategy {

    private static final int MOVE_DISTANCE = 1;
    @Override
    public void move(Car car) {
        CarLocation carLocation = car.getCarLocation();
        carLocation.increaseValue(MOVE_DISTANCE);
    }
}
