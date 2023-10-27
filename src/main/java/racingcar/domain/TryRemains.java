package racingcar.domain;

public class TryRemains {
    private int value;

    public TryRemains(int value) {
        this.value = value;
    }

    public void doTry() {
        value--;
    }

    public boolean isZero() {
        return value == 0;
    }
}
