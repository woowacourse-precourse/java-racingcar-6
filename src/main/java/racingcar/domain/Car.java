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

public class Car {


    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        moveCount = MOVE_COUNT_INITIAL;
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
        for (int i = 0; i < moveCount; i++) {
            result += ("-");
        }
        return result;
    }

    private void moveOrStop(int number) {
        if (number >= STANDARD_MOVE_CONDITION_NUMBER) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", moveCount=" + moveCount +
                '}';
    }
}
