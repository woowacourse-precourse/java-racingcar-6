package racingcar;

public class Cars {
    public final String carName;
    public int position = 0;

    public Cars(String carName) {
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
