package racingcar.domain.dto;

public class CarStatus {
    private final String name;
    private final int position;

    public CarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarStatus of(String carName, int carPosition) {
        return new CarStatus(carName, carPosition);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
