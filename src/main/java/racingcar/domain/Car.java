package racingcar.domain;

/*
 *   자동차의 관한 정보를 담당
 * */

import static racingcar.constant.CarConstant.MOVE_COUNT_INITIAL;

public class Car {

    private CarName name;
    //변수명 수정 해보기 클래스도 (distance)
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
