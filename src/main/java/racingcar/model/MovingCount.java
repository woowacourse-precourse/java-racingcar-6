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

    public int getEachMovingCount(int index) {
        return movingCount.get(index);
    }

    public int addCount(int index) {
        int count = this.movingCount.get(index);
        this.movingCount.set(index, ++count);
        return count;
    }

    public List<Integer> getMovingCount() {
        return this.movingCount;
    }
}
