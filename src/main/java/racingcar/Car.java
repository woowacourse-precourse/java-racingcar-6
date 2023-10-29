package racingcar;

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
        int randomNumber = moveStatus.getRandomNumber();
        if (moveStatus.canMove(randomNumber)) {
            position++;
        }
    }
}
