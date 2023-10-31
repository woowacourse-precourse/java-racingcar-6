package domain;

public class Progress {
    private int value;

    public Progress() {
        this.value = 0;
    }

    public Progress(int value) {
        this.value = value;
    }

    public Progress addValue() {
        return new Progress(this.value + 1);
    }

    public int getValue() {
        return this.value;
    }

}
