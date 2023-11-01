package racingcar.model;

public class Car {
    private final static String MOVING_MARK = "-";
    private String name;
    private int move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public void moveCar() {
        this.move++;
    }

    public int getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    private String getMoveMark() {
        return MOVING_MARK.repeat(this.move);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, getMoveMark());
    }
}
