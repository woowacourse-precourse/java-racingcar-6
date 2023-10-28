package racingcar.entity;

class Position {

    static final int INITIAL_POSITION = 0;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position newInstance() {
        return new Position(INITIAL_POSITION);
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
