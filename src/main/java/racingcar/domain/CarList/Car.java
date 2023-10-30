package racingcar.domain.CarList;

import racingcar.util.generator.RandomNumberGenerator;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private final static int MOVE_STANDARD_NUMBER = 4;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final String carName;
    private int position = DEFAULT_POSITION;
    private int randomNumber;

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public Car(String carName) {
        this.carName = carName;
    }

    public void checkMoveOrNot() {
        randomNumber = randomNumberGenerator.generate();
        if (randomNumber >= MOVE_STANDARD_NUMBER) {
            movePosition();
        }
    }

    private void movePosition() {
        this.position++;
    }

    public CarDto createDto() {
        CarDto carDto = new CarDto(this.carName, this.position);
        return carDto;
    }

}
