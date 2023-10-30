package racingcar.dto;

public class RacingCarDto {
    private final String name;
    private final int distance;

    public RacingCarDto(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
