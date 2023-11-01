package racingcar.domain;

public class Car {

    private static final int CONDITION_VALUE_FOR_MOVE = 4;
    private final String name;
    private final StringBuilder trace;
    private int position;

    public Car(String name) {
        this.name = name;
        this.trace = new StringBuilder();
        this.position = 0;
    }

    public void moveOrStop(int fuel) {
        if (fuel >= CONDITION_VALUE_FOR_MOVE) {
            move();
        } else {
            stop();
        }
    }

    private void move() {
        position++;
        trace.append("-");
        System.out.println(name + " : " + trace);
    }

    private void stop() {
        System.out.println(name + " : " + trace);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
