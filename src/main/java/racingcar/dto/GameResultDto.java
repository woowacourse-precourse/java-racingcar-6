package racingcar.dto;

public class GameResultDto {
    private String racingCarName;
    private int distance;

    public GameResultDto(String racingCarName, int distance) {
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
