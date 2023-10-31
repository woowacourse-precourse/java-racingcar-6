package racingcar.domain.dto;

public class CarDto {
    private final String name;
    private final int distance;

    private CarDto(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarDto createNewCarDto(String name, int distance) {
        return new CarDto(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
