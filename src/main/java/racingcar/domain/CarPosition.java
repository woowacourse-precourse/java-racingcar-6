package racingcar.domain;

import racingcar.domain.dto.CarPositionDto;

import java.util.Objects;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public CarPositionDto createPositionDto() {
        return new CarPositionDto(this.position);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
