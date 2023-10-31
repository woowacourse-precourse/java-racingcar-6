package racingcar.data;

public class AttemptIndex {
    private int index;

    public AttemptIndex() {
        this.index = 0;
    }

    public int toInt() {
        return index;
    }

    public void increase() {
        index++;
    }
}
