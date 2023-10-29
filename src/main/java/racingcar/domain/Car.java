package racingcar.domain;


public class Car {

    private final CarName name;
    private Position position = new Position(0);

    public Car(final CarName name) {
        this.name = name;
    }

    public void moveToCar(final int value) {
        if (value >= 4) {
            this.position = position.move();
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.position();
    }
}
