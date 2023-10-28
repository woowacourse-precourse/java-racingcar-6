package racingcar.domain;

public class TryCount {

    private int value = 0;

    public void increaseCount() {
        value++;
    }

    public boolean isProgress(int number) {
        return value != number;
    }
}
