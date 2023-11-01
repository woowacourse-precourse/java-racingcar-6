package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;
    private static final String MOVING_INDICATORS = "-";
    private final MovingCount movingCount;

    public RacingGame(MovingCount movingCount) {
        this.movingCount = movingCount;
    }

    public void moveCars(List<String> carList, List<Integer> numberList) {
        int size = numberList.size();
        for (int i = 0; i < size; i++) {
            int count = movingCount.getEachMovingCount(i);
            if (numberList.get(i) >= STANDARD_NUMBER) {
                System.out.println(carList.get(i) + " : " + MOVING_INDICATORS.repeat(movingCount.addCount(i)));
            }
            else {
                System.out.println(carList.get(i) + " : " + MOVING_INDICATORS.repeat(count));
            }
        }
        System.out.println();
    }
}
