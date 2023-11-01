package racingcar.domain;


public class Car {
    private final int INITIAL_DISTANCE = 0;
    private final int MOVABLE_NUMBER = 4;

    private final Name name;
    private int position = INITIAL_DISTANCE;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(int random) {
        if (random >= MOVABLE_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
