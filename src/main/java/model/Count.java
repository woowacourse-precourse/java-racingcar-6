package model;

public class Count implements Comparable<Count> {

    private static final int INITIAL_COUNT = 0;

    private Integer count;

    private Count(final int count) {
        this.count = count;
    }

    public static Count initialCount() {
        return new Count(INITIAL_COUNT);
    }

    public void addCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(final Count count) {
        return this.count - count.getCount();
    }

    @Override
    public boolean equals(final Object value) {
        if (this == value) {
            return true;
        }

        if (!(value instanceof Count countValue)) {
            return false;
        }

        return count.equals(countValue.getCount());
    }

    @Override
    public int hashCode() {
        return count.hashCode();
    }
}
