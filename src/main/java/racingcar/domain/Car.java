package racingcar.domain;

public class Car {

    private final Name name;
    private int position;

    public Car(String carName) {
        this.name = new Name(carName);
        this.position = 0;
    }

    public void move(CarStatus status) {
        if (status.isMove()) {
            position += status.distance;
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }
}
