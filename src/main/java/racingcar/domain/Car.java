package racingcar.domain;

public class Car {

    private final Name name;
    private int position;

    public Car(final String carName) {
        this.name = new Name(carName);
        this.position = 0;
    }

    public void move(final MoveCondition condition) {
        if (condition.isMove()) {
            position += condition.distance;
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public boolean isEqualToPosition(final int position) {
        return this.position == position;
    }
}
