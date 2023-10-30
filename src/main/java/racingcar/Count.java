package racingcar;

import java.util.Objects;

final class Count {

    private int times;

    Count(String input) {
        try {
            times = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if(times < 1) throw new IllegalArgumentException();
    }

    boolean isEnd() {
        return times == 0;
    }

    void countDown() {
        times--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return times == count.times;
    }

    @Override
    public int hashCode() {
        return Objects.hash(times);
    }
}
