package racingcar.model;

public class Position {
    private static final int ZERO_POSITION = 0;
    private static final int MOVE_SIZE = 1;
    private static final String DISPLAY_STRING = "-";
    private int position;

    public Position() {
        position = ZERO_POSITION;
    }

    public void movePosition() {
        this.position += MOVE_SIZE;
    }

    public int getPosition() {
        return this.position;
    
    public String getDisplayFormat() {
        return DISPLAY_STRING.repeat(position);
    }
    }

    @Override
    public String toString() {
        return DISPLAY_STRING.repeat(this.position);
    }
}
