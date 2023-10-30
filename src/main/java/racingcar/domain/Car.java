package racingcar.domain;

public class Car {

    public static final int INIT_POSITION = 0;
    private static final int MIN_MOVE_NUMBER = 4;

    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = INIT_POSITION;
    }

    public void move(int number) {
        if (number >= MIN_MOVE_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
