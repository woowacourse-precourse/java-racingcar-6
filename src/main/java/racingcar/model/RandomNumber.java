package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

//자동차 이름 개수만큼 랜덤숫자를 생성
public class RandomNumber {
    private int number;
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;
    private static final int MOVABLE_NUMBER = 4;

    private RandomNumber(int number) {
        this.number = number;
    }

    public static RandomNumber makeRandomNumber() {
        int number = pickNumberInRange(START_RANGE, END_RANGE);
        return new RandomNumber(number);
    }

    public boolean isMovable() {
        return number >= MOVABLE_NUMBER;
    }
}