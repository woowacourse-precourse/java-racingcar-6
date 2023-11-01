package racingcar.domain.dto;

public class CarStatusDto {

    private final String name;

    private final int carPosition;

    private CarStatusDto(final String name, final int carPosition) {
        this.name = name;
        this.carPosition = carPosition;
    }

    public static CarStatusDto create(final String name, final int carPosition) {
        return new CarStatusDto(name, carPosition);
    }

    public String getName() {
        return name;
    }

    public int getCarPosition() {
        return carPosition;
    }
    
}
