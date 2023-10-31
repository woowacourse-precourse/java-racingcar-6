package domain;

public class Progress implements Comparable<Progress> {
    private int value;

    public Progress() {
        this.value = 0;
    }

    private Progress(int value) {
        this.value = value;
    }

    public Progress addValue() {
        return new Progress(this.value + 1);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Progress o) {
        if (this.value > o.value) {
            return 1;
        }

        return -1;
    }
}
