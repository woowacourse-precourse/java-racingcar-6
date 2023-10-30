package racingcar.dto;

public class MidGameResultDto {
    private String racingCarName;
    private int distance;

    public MidGameResultDto(String racingCarName, int distance) {
        this.racingCarName = racingCarName;
        this.distance = distance;
    }

    public String getRacingCarName() {
        return this.racingCarName;
    }

    public int getDistance() {
        return this.distance;
    }
}
