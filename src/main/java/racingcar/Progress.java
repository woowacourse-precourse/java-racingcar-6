package racingcar;

import java.util.Objects;

public class Progress {
    private int progress;

    public Progress() {
        this.progress = 0;
    }

    public void movable(int number) {
        if (number > 4) {
            move(1);
        }
    }

    private void move(int number) {
        progress += number;
    }

    public int getProgress() {
        return progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Progress progress1 = (Progress) o;
        return progress == progress1.progress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(progress);
    }
}
