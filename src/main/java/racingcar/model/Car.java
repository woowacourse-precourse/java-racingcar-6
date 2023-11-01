package racingcar.model;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position();
    }

    public void movePosition() {
        position.move();
    }

    public boolean isWinner(Position maxPosition) {
        return maxPosition.equals(position);
    }

    public boolean isGreaterPositionThan(Position maxPosition) {
        return position.isGreaterThan(maxPosition);
    }

    public String getResultFormat() {
        return getNameFormat() + " : " + getPositionFormat();
    }

    public String getNameFormat() {
        return name.format();
    }

    private String getPositionFormat() {
        return position.format();
    }

    public Position position() {
        return this.position;
    }
}
