package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        assertValidName(name);

        this.name = name;
        this.position = 0;
    }

    private void assertValidName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Invalid Name");
        }
    }

    public void move(MoveCarType moveCarType) {
        position += moveCarType.getMovingPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
