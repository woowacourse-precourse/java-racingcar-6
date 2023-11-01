package racingcar.domain;

public class Car {

    public static final int INIT_POSITION = 0;

    private final CarName CarName;
    private int position;

    public Car(String CarName) {
        this.CarName = new CarName(CarName);
        this.position = INIT_POSITION;
    }

    public void move(boolean isMove) {
        if (isMove) {
            increasePosition();
        }
    }

    private int increasePosition() {
        return position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return CarName.name();
    }

    public int getPosition() {
        return position;
    }
}
