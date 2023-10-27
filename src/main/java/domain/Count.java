package domain;

import static constant.ConstantString.INITIAL_COUNT;

public class Count {
    private int count;

    public Count() {
        this.count = INITIAL_COUNT;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
