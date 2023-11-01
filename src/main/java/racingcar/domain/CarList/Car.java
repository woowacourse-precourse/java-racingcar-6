package racingcar.domain.CarList;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_STANDARD_NUMBER = 4;

    private final String carName;
    private int position = DEFAULT_POSITION;

    public Car(String carName) {
        this.carName = carName;
    }

    public void checkMoveOrNot(int randomNumber) {
        if (randomNumber >= MOVE_STANDARD_NUMBER) {
            movePosition();
        }
    }

    private void movePosition() {
        this.position++;
    }

    public CarDto createDto() {
        return new CarDto(this.carName, this.position);
    }

}
