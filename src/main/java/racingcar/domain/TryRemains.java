package racingcar.domain;

public class TryRemains {
    private int value;

    public TryRemains(int value) {
        this.value = value;
    }

    void doTry() {
        value--;
    }
}
