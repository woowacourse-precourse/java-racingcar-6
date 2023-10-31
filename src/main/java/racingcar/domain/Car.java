package racingcar.domain;

public class Car {
    private final Name name;
    private int position = 0;

    private Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public static Car getNewCar(String name) {
        return new Car(name);
    }

    public void move(boolean isCanMove) {
        if (isCanMove) {
            position += 1;
        }
    }
}
