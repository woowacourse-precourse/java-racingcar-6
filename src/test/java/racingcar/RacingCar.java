package racingcar;

public class RacingCar implements Car {

    private final static String ROAD_PRINT = "-";
    private final Long position;
    private final String carName;

    private RacingCar(String carName, Long position) {
        this.carName = carName;
        this.position = position;
    }

    public static RacingCar of(String carName) {
        return new RacingCar(carName, 0L);
    }

    @Override
    public Car runAndReturnNewCar(Long randomNum) {
        if (randomNum >= 4L) {
            return new RacingCar(carName, position + 1L);
        }
        return this;
    }

    @Override
    public String getCarStatus() {
        return carName + " : " + buildPositionRepresentation();
    }

    @Override
    public Long getPosition() {
        return position;
    }

    @Override
    public String getCarName() {
        return carName;
    }

    private String buildPositionRepresentation() {
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < position; i++) {
            path.append(ROAD_PRINT);
        }
        return path.toString();
    }
}
