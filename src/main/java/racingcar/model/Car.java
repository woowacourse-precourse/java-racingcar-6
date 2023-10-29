package racingcar.model;

public class Car implements Comparable<Car> {

    private static final int MIN_FORWARD_NUMBER = 4;
    private static final int POSITION_DEFAULT = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = POSITION_DEFAULT;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(int randomNumber) {
        if (randomNumber >= MIN_FORWARD_NUMBER) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Car car) {
        if (car.position < position) {
            return 1;
        }
        if (car.position > position) {
            return -1;
        }
        return 0;
    }
}
