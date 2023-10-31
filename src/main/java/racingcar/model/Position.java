package racingcar.model;

public class Position {
    private static final Integer START_POSITION = 0;
    private int position; // final 사용불가

    public Position() {
        this.position = START_POSITION;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

//    @Override
//    public String toString() {
//        return String.valueOf(position);
//    }
}