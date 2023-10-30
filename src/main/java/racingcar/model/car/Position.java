package racingcar.model.car;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void plus() {
        this.position++;
    }

    public int get() {
        return this.position;
    }
}
