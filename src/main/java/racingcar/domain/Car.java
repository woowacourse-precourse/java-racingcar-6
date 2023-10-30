package racingcar.domain;


public class Car {
    public static final String CAR_POSITION_SIGN = "-";
    private final CarName name;
    private final Position position;
    private final int speed;

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
        this.speed = 1;
    }

    public boolean isSamePosition(int position) {
        return this.position.getAmount() == position;
    }

    public void moveForward() {
        position.increment(speed);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getAmount();
    }

    @Override
    public String toString() {
        return name.getName() + " : " + CAR_POSITION_SIGN.repeat(position.getAmount());
    }
}
