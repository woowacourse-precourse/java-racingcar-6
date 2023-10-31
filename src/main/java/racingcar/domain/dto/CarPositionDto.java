package racingcar.domain.dto;

public class CarPositionDto {
    private final int position;

    public CarPositionDto(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }
}
