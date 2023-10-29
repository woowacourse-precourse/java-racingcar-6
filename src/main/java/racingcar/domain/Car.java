package racingcar.domain;

public class Car {

    private final CarName name;
    private final CarPosition position;

    private Car(final CarName name, final CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(final String name, final int positionValue) {
        return new Car(CarName.from(name), new CarPosition(positionValue));
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void moveForward(final int randomNumber) {
        if (ForwardCondition.isMovableNumber(randomNumber)) {
            position.increase(ForwardCondition.FORWARD_AMOUNT.getValue());
        }
    }

    public boolean isWinner(final int winnerPosition) {
        return position.isSame(winnerPosition);
    }
}
