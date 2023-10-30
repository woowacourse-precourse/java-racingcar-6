package racingcar.dto;

public class CarDto {
    private final String name;
    private final int position;

    private CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto of(String name, int position) {
        return new CarDto(name, position);
    }
}
