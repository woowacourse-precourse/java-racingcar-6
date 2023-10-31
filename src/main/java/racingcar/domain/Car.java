package racingcar.domain;

/*
 *   자동차의 관한 정보를 담당
 * */

public class Car {

    public static final int MOVE_COUNT_INITIAL = 0;

    private CarName name;
    private int moveDistance;

    private Car(CarName carName) {
        this.name = carName;
        this.moveDistance = MOVE_COUNT_INITIAL;
    }

    public static Car from(CarName carName) {
        return new Car(carName);
    }

    public String getName() {
        return name.getValue();
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void moveForward() {
        moveDistance++;
    }
}
