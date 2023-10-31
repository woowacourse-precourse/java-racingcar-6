package racingcar.model;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position();
    }

    public void move() {
        position.movePosition();
    }

    public boolean isWinner(Position maxPosition) {
        if (maxPosition.equals(position)) {
            return true;
        }
        return false;
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
