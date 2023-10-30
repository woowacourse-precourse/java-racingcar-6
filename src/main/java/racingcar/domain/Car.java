package racingcar.domain;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void plusPosition() {
        this.position.plusNum();
    }
}