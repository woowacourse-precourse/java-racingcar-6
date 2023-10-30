package racingcar.domain;

public class Count {
    private int value;

    public Count(int value) {
        this.value = value;
    }

    public void decrease() {
        value--;
    }

    public boolean playable() {
        return value != 0;
    }
}
