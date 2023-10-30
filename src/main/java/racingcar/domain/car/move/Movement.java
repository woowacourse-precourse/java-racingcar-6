package racingcar.domain.car.move;

public abstract class Movement implements Comparable<Movement> {
    private int position;
    public abstract void move();

    private int getPosition() {
        return position;
    }

    protected void addPosition(int add) {
        position += add;
    }

    @Override
    public int compareTo(Movement o) {
        return getPosition() - o.getPosition();
    }

    public String toStringBar() {
        return "-".repeat(position);
    }
}
