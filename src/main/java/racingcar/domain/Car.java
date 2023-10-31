package racingcar.domain;


import racingcar.Utils;

public class Car {
    public static final String CAR_POSITION_SIGN = "-";
    public static final int START_POSITION = 0;
    private final CarName name;
    private final Position position;
    private final int speed;

    public Car(CarName name) {
        this.name = name;
        this.position = new Position(START_POSITION);
        this.speed = 1;
    }

    public boolean isSamePosition(int position) {
        return this.position.getAmount() == position;
    }

    public void moveRandomly() {
        if (Utils.isTrueWithProbability60Percent()) {
            position.increment(speed);
        }
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
