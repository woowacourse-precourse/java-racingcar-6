package racingcar.domain;

/*
 *   자동차의 관한 정보를 담당
 * */

import static racingcar.constant.CarConstant.MOVE_COUNT_INITIAL;
import static racingcar.constant.CarConstant.STANDARD_MOVE_CONDITION_NUMBER;

import java.util.List;
import racingcar.dto.CarNames;

public class Car implements Comparable<Car> {

    private static final String MOVE_SIGN = "-";
    private String name;
    private int record;

    public Car(String name) {
        this.name = name;
        record = MOVE_COUNT_INITIAL;
    }


    public void addNameToList(List<String> names) {
        names.add(name);
    }


    public void moveOrStop(int number) {
        if (number >= STANDARD_MOVE_CONDITION_NUMBER) {
            record++;
        }
    }

    public String recordToMoveSign() {
        return name + " : " + MOVE_SIGN.repeat(record);
    }

    //함수명 네이밍 처리 잘 되었나
    public int getBiggerRecord(int maxRecord) {
        return Integer.max(this.record, maxRecord);
    }


    @Override
    public int compareTo(Car compareCar) {
        return -Integer.compare(this.record, compareCar.record);
    }

    public boolean isEqualRecord(int record) {
        if (this.record == record) {
            return true;
        }
        return false;
    }

    public void intoCarNames(CarNames carNames) {
        carNames.addName(name);
    }
}
