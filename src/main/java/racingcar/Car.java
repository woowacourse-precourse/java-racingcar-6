package racingcar;

public final class Car {
    private String name;
    public Integer postion;
    private Car(final String givenName) {
        this.name = givenName;
        this.postion = 0 ;
    }
    public static Car applyName(final String givenName) {
        return new Car(givenName);
    }

    @Override
    public String toString() {
        return name;
    }
    public Integer changePosition(final CarMovementStatus movementStatus) {
        if(movementStatus.equals(CarMovementStatus.MOVE_FORWARD)) return ++postion;
        if(movementStatus.equals(CarMovementStatus.STOP)) return postion;
        throw new IllegalArgumentException();
    }
}
