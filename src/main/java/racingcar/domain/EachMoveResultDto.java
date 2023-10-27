package racingcar.domain;

public class EachMoveResultDto {
    private final String carName;
    private final int position;

    public EachMoveResultDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
