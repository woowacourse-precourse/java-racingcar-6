package racingcar.model;

public class Car {

    private static final int CAR_ADVANCE_NUMBER = 4;
    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void addAdvances(final int randomNumber) {
        if (randomNumber >= CAR_ADVANCE_NUMBER) {
            position.add();
        }
    }

    public String getCarName() {
        return name.getName();
    }

    public int getCarAdvances() {
        return position.getValue();
    }
}
