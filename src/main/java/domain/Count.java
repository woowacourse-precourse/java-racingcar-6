package domain;

public class Count {
    private int count;

    public Count() {
        this.count = 0;
    }

    public void plusForward() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}
