package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class MovingCount {
    private List<Integer> movingCount = new ArrayList<>();

    public void initMovingCount(int size) {
        for (int i = 0; i < size; i++) {
            movingCount.add(i, 0);
        }
    }
}
