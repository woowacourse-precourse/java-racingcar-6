package racingcar.domain;

import racingcar.common.RandomNumberGenerator;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarPositionDto;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int CONDITION_NUMBER=4;
    private final String carName;
    private final CarPosition carPosition;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(final String carName,final RandomNumberGenerator randomNumberGenerator) {
        validateCarNameLength(carName);
        this.carName = carName;
        this.carPosition= new CarPosition();
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private void validateCarNameLength(final String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    public void move() {
        if (shouldMove()) {
            this.carPosition.move();
        }
    }

    private boolean shouldMove() {
        int randomNumber = randomNumberGenerator.generate();
        return randomNumber >= CONDITION_NUMBER;
    }

    public CarDto toCarDto() {
        CarPositionDto carPositionDto =carPosition.createPositionDto();
        return new CarDto(this.carName,carPositionDto.getPosition() );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return Objects.equals(this.carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
