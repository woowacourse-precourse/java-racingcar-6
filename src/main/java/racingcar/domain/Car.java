package racingcar.domain;

/*
 *   자동차의 관한 정보를 담당
 * */

import static racingcar.constant.CarConstant.MAX_MOVE_CONDITION_NUMBER;
import static racingcar.constant.CarConstant.MIN_MOVE_CONDITION_NUMBER;
import static racingcar.constant.CarConstant.MOVE_COUNT_INITIAL;
import static racingcar.constant.CarConstant.STANDARD_MOVE_CONDITION_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.OutputView;

public class Car implements Comparable<Car> {

    private String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
        moveDistance = MOVE_COUNT_INITIAL;
    }

    public static int findBiggerRecord(int bestRecord, Car car) {
        return Integer.max(bestRecord, car.moveDistance);
    }

    public void addNameToList(List<String> names) {
        names.add(name);
    }

    public void move() {
        int number = Randoms.pickNumberInRange(MIN_MOVE_CONDITION_NUMBER, MAX_MOVE_CONDITION_NUMBER);
        moveOrStop(number);
        OutputView.moveResult(moveResultToString());
    }

    private String moveResultToString() {
        String result = name + " : ";
        for (int i = 0; i < moveDistance; i++) {
            result += ("-");
        }
        return result;
    }

    private void moveOrStop(int number) {
        if (number >= STANDARD_MOVE_CONDITION_NUMBER) {
            moveDistance++;
        }
    }

    @Override
    public int compareTo(Car compareCar) {
        return -Integer.compare(this.moveDistance, compareCar.moveDistance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", moveCount=" + moveDistance +
                '}';
    }

    public boolean isEqualRecord(int record) {
        if (moveDistance == record) {
            return true;
        }
        return false;
    }

    public String intoWinnersName(String winnersName) {
        return winnersName += name;
    }
}
