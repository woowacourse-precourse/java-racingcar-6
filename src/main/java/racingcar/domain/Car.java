package racingcar.domain;

/*
 *   자동차의 관한 정보를 담당
 * */

import static racingcar.constant.CarConstant.MOVE_COUNT_INITIAL;
import static racingcar.constant.CarConstant.STANDARD_MOVE_CONDITION_NUMBER;

public class Car implements Comparable<Car> {


    private CarName name;
    //변수명 수정 해보기 클래스도 (distance)
    private int moveDistance;

    public Car(CarName carName) {
        this.name = carName;
        this.moveDistance = MOVE_COUNT_INITIAL;
    }

    public String getName() {
        return name.getValue();
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void moveOrStop(int number) {
        if (number >= STANDARD_MOVE_CONDITION_NUMBER) {
            moveDistance++;
        }
    }


    //함수명 네이밍 처리 잘 되었나
    public int getBiggerRecord(int maxRecord) {
        return Integer.max(this.moveDistance, maxRecord);
    }


    @Override
    public int compareTo(Car compareCar) {
        return -Integer.compare(this.moveDistance, compareCar.moveDistance);
    }

    public boolean isEqualRecord(int record) {
        if (this.moveDistance == record) {
            return true;
        }
        return false;
    }

}
