package racingcar.model.car;


public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final String colon = " : ";
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        position = INITIAL_POSITION;
    }

    public void moveForward(boolean move) {
        if (move) {
            position++;
        }
    }

    public boolean isFurtherThan(Car another) {
        return this.position >= another.position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.getCarName() + colon;
    }

}