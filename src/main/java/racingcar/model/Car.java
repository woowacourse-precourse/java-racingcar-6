package racingcar.model;

public class Car {

    private final CarName carName;
    private final Position position;

    public Car(String name) {
        this.carName = new CarName(name);
        position = new Position();
    }

    public void movePosition() {
        position.move();
    }

    public String getNameFormat() {
        return carName.format();
    }

    private String getPositionFormat() {
        return position.format();
    }

    public Position position() {
        return this.position;
    }

    public String getResultFormat() {
        return getNameFormat() + " : " + getPositionFormat();
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


}
