package racingcar.domain;

public class Car {
    private final CarName carName;
    private int position = 0;
    public Car(String name) {
        this.carName = new CarName(name);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }
}
