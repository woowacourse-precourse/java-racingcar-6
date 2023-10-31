package racingcar.model;

public class RacingCar implements Car {

    private static final String ROAD_PRINT = "-";

    private static final Long RANDOM_BOUNDER = 4L;

    private static final Long MOVE_NUM = 1L;

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
        if (randomNum >= RANDOM_BOUNDER) {
            return new RacingCar(carName, position + MOVE_NUM);
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
