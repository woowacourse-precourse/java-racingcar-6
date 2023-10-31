package racingcar.domain;

import racingcar.common.RandomNumberGenerator;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarPositionDto;

import java.util.Objects;

public class Car {
    private static final int CONDITION_NUMBER=4;
    private final Name carName;
    private final CarPosition carPosition;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(final String carName,final RandomNumberGenerator randomNumberGenerator) {
        this.carName = new Name(carName);
        this.carPosition= new CarPosition();
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void move() {
        if (shouldMove()) {
            this.carPosition.move();
        }
    }

    private boolean shouldMove() {
        int randomNumber = this.randomNumberGenerator.generate();
        return randomNumber >= CONDITION_NUMBER;
    }

    public CarDto toCarDto() {
        CarPositionDto carPositionDto = this.carPosition.createPositionDto();
        return new CarDto(this.carName.value(),carPositionDto.position() );
    }

    public CarPositionDto createPositionDto() {
        return this.carPosition.createPositionDto();
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
        return Objects.hash(this.carName);
    }
}
