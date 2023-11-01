package racingcar.race;

public class Car {
    private final String carName;
    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public void move(MoveStatus moveStatus) {
        if (moveStatus.canMove()) {
            position++;
        }
    }
}
