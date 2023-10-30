package racingcar.domain;

public class EachGameResultDto {
    private final String carName;
    private final int position;

    public EachGameResultDto(String carName, int position) {
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
