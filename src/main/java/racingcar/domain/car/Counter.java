package racingcar.domain.car;

public class Counter {

    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public boolean isEnd() {
        if (count <= 0) {
            return true;
        }
        return false;
    }

    public void reduceCount() {
        count--;
    }
}
