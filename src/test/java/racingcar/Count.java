package racingcar;

import java.util.Objects;

final class Count {

    private long times;

    private Count() {
    }

    static Count create(String input) {
        Count instance = new Count();
        try {
            instance.times = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return instance;
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
