package racingcar;

import java.util.Objects;

final class Count {

    private int times;

    private Count() {
    }

    static Count create(String input) {
        Count instance = new Count();
        try {
            instance.times = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if(instance.times < 1) throw new IllegalArgumentException();
        return instance;
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
