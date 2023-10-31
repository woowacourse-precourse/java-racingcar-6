package racingcar.domain.primitivewraper;

import java.util.Objects;

public class Progress {
    private static final int CUT = 4;
    private static final int POINT = 1;
    private int progress;

    public Progress() {
        this.progress = 0;
    }

    public void movable(int number) {
        if (number >= CUT) {
            move(POINT);
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
