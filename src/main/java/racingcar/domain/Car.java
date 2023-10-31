package racingcar.domain;

public class Car {

    private static final int CAR_START_POSITION = 0;
    private static final int CAR_CAN_GO_NUMBER = 4;

    private final Name name;
    private final Position position;

    private Car(final String name) {
        this.name = new Name(name);
        this.position = new Position(CAR_START_POSITION);
    }

    public static Car from(final String name) {
        return new Car(name);
    }


    public void go(final int number) {
        if (isAbleToGo(number)) {
            position.plus();
        }

    }

    private static boolean isAbleToGo(final int number) {
        return number >= CAR_CAN_GO_NUMBER;
    }

    public Boolean isHere(final Position position) {
        return this.position.equals(position);
    }

    public String getNameString() {
        return name.name();
    }

    public int getPositionInt() {
        return position.getValue();
    }

    public Position getPosition() {
        return new Position(position.getValue());
    }


}
