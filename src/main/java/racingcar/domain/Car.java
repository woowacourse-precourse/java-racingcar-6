package racingcar.domain;

public class Car {
    public static final Integer NAME_VALIDATION_LENGTH = 5;
    public static final Integer CAR_FORWARD_JUDGMENT_CRITERIA = 4;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    private void validateName(String name) {
        if (name.length() >= NAME_VALIDATION_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void go(int randNumber) {
        if (randNumber >= CAR_FORWARD_JUDGMENT_CRITERIA) {
            position.move();
        }
    }

    public Integer getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
