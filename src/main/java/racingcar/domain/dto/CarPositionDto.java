package racingcar.domain.dto;

public class CarPositionDto {
    private final int position;

    public CarPositionDto(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
