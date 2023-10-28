package domain;

import static constant.ConstantString.INITIAL_COUNT;

public class MoveCount {
    private int count;

    public MoveCount() {
        this.count = INITIAL_COUNT;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}
