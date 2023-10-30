package racingcar.domain.CarList;

import racingcar.util.generator.RandomNumberGenerator;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private final static int MOVE_STANDARD_NUMBER = 4;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final String carName;
    private int position = DEFAULT_POSITION;

    private CarDto createDto() {
        return new CarDto(carName, position);
    }

    public Car(String carName) {
        this.carName = carName;
    }

    private void MovePosition() {
        this.position++;
    }

    public CarDto setMoveStatus() {
        int randomNumber = randomNumberGenerator.generate();
        if (randomNumber >= MOVE_STANDARD_NUMBER) {
            MovePosition();
        }
        return createDto();
    }
}
