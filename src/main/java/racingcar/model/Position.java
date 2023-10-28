package racingcar.model;

public class Position {
    private int position;

    public void carMove(int distance) {
        this.position += distance;
    }

    public int toInt() {
        return this.position;
    }
}
